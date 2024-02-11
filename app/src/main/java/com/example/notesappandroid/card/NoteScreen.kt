package com.example.notesappandroid.card

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.notesappandroid.note.Note
import com.example.notesappandroid.R
import com.example.notesappandroid.ui.theme.NotesAppAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    noteScreenParameters: NoteScreenParameters
) {
    noteScreenParameters.apply {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.noteScreenTitle)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onClickNavigationIcon
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(id = R.string.noteScreenNavigationIconContentDescription)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = onClickMenu) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(id = R.string.noteScreenDropDownMenuIconContentDescription)
                            )
                        }
                        DropdownMenu(
                            expanded = menuExpanded,
                            onDismissRequest = onClickMenu
                        ) {
                            DropdownMenuItem(
                                text = {
                                       Text(text =
                                        stringResource(id = R.string.option1)
                                       )
                                },
                                onClick = onClickAmend
                            )
                            DropdownMenuItem(
                                text = {
                                    Text(text =
                                    stringResource(id = R.string.option2)
                                    )
                                },
                                onClick = onClickRemove
                            )
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                ) {
                    NoteCard(
                        noteParameters = NoteParameters(
                            title = note.title,
                            content = note.content
                        )
                    )
                }
            }
        )
    }
}

data class NoteScreenParameters(
    val note: Note,
    var menuExpanded: Boolean,
    val onClickNavigationIcon: () -> Unit = {},
    val onClickMenu: () -> Unit = {},
    val onClickAmend: () -> Unit = {},
    val onClickRemove: () -> Unit = {}
)

fun generateNoteScreenParameters(
    note: Note,
    menuExpanded: Boolean,
    onClickMenu: () -> Unit = {},
    onClickNavigationIcon: () -> Unit = {}
): NoteScreenParameters {
    return NoteScreenParameters(
        note = note,
        menuExpanded = menuExpanded,
        onClickMenu = onClickMenu,
        onClickNavigationIcon = onClickNavigationIcon
    )
}

class NoteScreenParametersProvider : PreviewParameterProvider<NoteScreenParameters> {
    override val values: Sequence<NoteScreenParameters> = sequenceOf(
        NoteScreenParameters(
            note = Note(
                title = "Shopping list:",
                content = "\nSoap\nDetergent\nFabric conditioner\nMilk\nSnacks"
            ),
            menuExpanded = false
        )
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun NoteScreenPreview(
    @PreviewParameter(NoteScreenParametersProvider::class)
    parameters: NoteScreenParameters
) {
    NotesAppAndroidTheme {
        NoteScreen(
            noteScreenParameters = parameters
        )
    }
}
