package com.example.notesappandroid.homescreen

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.notesappandroid.R
import com.example.notesappandroid.note.Note
import com.example.notesappandroid.ui.theme.NotesAppAndroidTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTests {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val resources = context.resources
    private var onNoteClicked = 0

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        onNoteClicked = 0
        composeTestRule.setContent {
            NotesAppAndroidTheme {
                HomeScreen(
                    generateHomeScreenParameters(
                        list = listOf(
                            Note(
                                title = "Shopping list:",
                                content = "\nSoap\nDetergent\nFabric conditioner\nMilk\nSnacks"
                            )
                        ),
                        onNoteClick = { onNoteClicked++ }
                    )
                )
            }
        }
    }

    @Test
    fun textDisplayed() {
        composeTestRule.apply {
            onNodeWithText(
                resources.getString(R.string.homeScreenHeader)
            ).apply {
                assertIsDisplayed()
            }

            onNodeWithText(
                "Shopping list:"
            ).apply {
                assertIsDisplayed()
            }

            onNodeWithText(
                "\nSoap\nDetergent\nFabric conditioner\nMilk\nSnacks"
            ).apply {
                assertIsDisplayed()
            }
        }
    }
}