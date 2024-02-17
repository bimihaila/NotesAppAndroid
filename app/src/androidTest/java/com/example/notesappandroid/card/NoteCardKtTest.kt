package com.example.notesappandroid.card

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.notesappandroid.R
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteCardKtTest {
    private val context: Context = ApplicationProvider.getApplicationContext()
    private val resources = context.resources
    private val parameters = NoteCardParametersProvider().values.toList()[0]
    private var onCardClick = 0

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            onCardClick = 0
            NoteCard(
                noteParameters = parameters,
                onNoteClick = { onCardClick++ }
            )
        }
    }

    @Test
    fun displayText() {
        composeTestRule.apply{
            onNodeWithText(
                "Shopping list:"
            ).apply {
                assertIsDisplayed()
            }

            onNodeWithText(
                "Soap\nDetergent\nFabric conditioner\nMilk\nSnacks"
            ).apply {
                assertIsDisplayed()
            }
        }
    }

    @Test
    fun onCardClick() {
        composeTestRule.apply {
            onNodeWithTag(
                resources.getString(R.string.noteCardTestTag)
            ).performClick()
            assertEquals(1, onCardClick)
        }
    }
}