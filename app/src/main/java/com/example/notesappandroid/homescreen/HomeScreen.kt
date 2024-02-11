package com.example.notesappandroid.homescreen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.notesappandroid.R
import com.example.notesappandroid.ui.theme.NotesAppAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    parameters: HomeScreenParameters
) {
    parameters.apply {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = R.string.homeScreenHeader)
                        )
                    }
                )
            },
            content = {paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                ) {
                    Text(
                        text = title
                    )
                }
            }
        )
    }
}

data class HomeScreenParameters(
    val title: String = "Hello"
)

class HomeScreenParametersProvider: PreviewParameterProvider<HomeScreenParameters> {
    override val values: Sequence<HomeScreenParameters> = sequenceOf(
        HomeScreenParameters(
            title = "Hello"
        )
    )
}

@Preview(
    showBackground = true,

    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenParametersProvider::class)
    parameters: HomeScreenParameters
) {
    NotesAppAndroidTheme {
        HomeScreen(
            parameters = parameters
        )
    }
}

