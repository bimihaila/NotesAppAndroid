package com.example.notesappandroid.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.notesappandroid.Note

@Composable
fun NoteScreen(
    noteScreenParameters: NoteScreenParameters
) {

}

data class NoteScreenParameters(
    val note: Note,
    val onClickNavigationIcon: () -> Unit = {},
    val onClickMenu: () -> Unit = {}
)

class NoteScreenParametersProvider : PreviewParameterProvider<NoteScreenParameters> {
    override val values: Sequence<NoteScreenParameters> = sequenceOf(
        NoteScreenParameters(
            note = Note(
                title = "Shopping list:",
                content = "\nSoap\nDetergent\nFabric conditioner\nMilk\nSnacks"
            )
        )
    )
}


