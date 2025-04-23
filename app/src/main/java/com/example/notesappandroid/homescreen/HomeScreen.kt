package com.example.notesappandroid.homescreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesappandroid.note.Note
import com.example.notesappandroid.R
import com.example.notesappandroid.card.NoteCard
import com.example.notesappandroid.card.NoteParameters
import com.example.notesappandroid.ui.theme.NotesAppAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    list: List<Note> = listOf(),
    onNoteClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.homeScreenHeader)
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            items(list.size) { note ->
                NoteCard(
                    noteParameters = NoteParameters(
                        title = list[note].title,
                        content = list[note].content
                    ),
                    onNoteClick = onNoteClick
                )
            }
        }
    }
}

data class HomeScreenParameters(
    val list: List<Note> = listOf(),
    val onNoteClick: () -> Unit = {}
)

fun generateHomeScreenParameters(
    list: List<Note>,
    onNoteClick: () -> Unit = {}
): HomeScreenParameters {
    return HomeScreenParameters(
        list = list,
        onNoteClick = onNoteClick
    )
}

class HomeScreenParametersProvider: PreviewParameterProvider<HomeScreenParameters> {
    override val values: Sequence<HomeScreenParameters> = sequenceOf(
        generateHomeScreenParameters(
            list = listOf(
                Note(
                    title = "Shopping list:",
                    content = "\nSoap\nDetergent\nFabric conditioner\nMilk\nSnacks"
                ),
                Note(
                    content = "Need to call the doctor and to put an alarm to put the clothes" +
                            "in the washing machine."
                ),
                Note(
                    title = "Class notes",
                    content = "Missed my class.."
                )
            )
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
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenParametersProvider::class)
    parameters: HomeScreenParameters
) {
    NotesAppAndroidTheme {
        HomeScreen(
            list = parameters.list,
            onNoteClick = parameters.onNoteClick
        )
    }
}

