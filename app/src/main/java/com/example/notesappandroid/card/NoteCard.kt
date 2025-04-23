package com.example.notesappandroid.card

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.notesappandroid.R
import com.example.notesappandroid.ui.theme.NotesAppAndroidTheme
import com.example.notesappandroid.ui.theme.mediumPadding
import com.example.notesappandroid.ui.theme.smallPadding

@Composable
fun NoteCard(
    noteParameters: NoteParameters,
    onNoteClick: () -> Unit = {}
) {
   noteParameters.apply {
       val colors = arrayOf(
           MaterialTheme.colorScheme.primary,
           MaterialTheme.colorScheme.secondary,
           MaterialTheme.colorScheme.tertiary
       )

       Card(
           onClick = onNoteClick,
           modifier = Modifier
               .fillMaxWidth()
               .padding(smallPadding)
               .testTag(
                   stringResource(id = R.string.noteCardTestTag)
               )
               .then(
                   noteModifier
               ),
           colors = CardDefaults.cardColors(
               containerColor = color
           )
       ) {
           Text(
               text = title ?: stringResource(id = R.string.noteCardEmptyNoteTitle),
               style = MaterialTheme.typography.titleLarge,
               modifier = Modifier
                   .padding(
                       start = smallPadding,
                       end = smallPadding,
                       top = mediumPadding
                   )
           )

           Column {
                Text(
                    text = content,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = smallPadding,
                            bottom = smallPadding,
                            start = smallPadding,
                            end = smallPadding
                        )
                )
           }
       }
   }
}

data class NoteParameters(
    val title: String? = null,
    val content: String,
    val expanded: Boolean = true,
    val color: Color = Color.Unspecified,
    val noteModifier: Modifier = Modifier
)

class NoteCardParametersProvider : PreviewParameterProvider<NoteParameters> {
    override val values: Sequence<NoteParameters> = sequenceOf(
        NoteParameters(
            title = "Shopping list:",
            content = "Soap\nDetergent\nFabric conditioner\nMilk\nSnacks"
        ),
        NoteParameters(
            content = "Need to call the doctor and to put an alarm to put the clothes" +
                    "in the washing machine."
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
fun NoteCardPreview(
    @PreviewParameter(NoteCardParametersProvider::class)
    parameters: NoteParameters
) {
    NotesAppAndroidTheme {
        NoteCard(
            noteParameters = parameters
        )
    }
}
