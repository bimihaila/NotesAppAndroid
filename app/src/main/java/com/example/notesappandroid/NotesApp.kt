package com.example.notesappandroid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappandroid.card.NoteScreen
import com.example.notesappandroid.card.generateNoteScreenParameters
import com.example.notesappandroid.homescreen.HomeScreen
import com.example.notesappandroid.homescreen.HomeScreenParameters
import com.example.notesappandroid.navigation.Navigation
import com.example.notesappandroid.note.Note

@Composable
fun NotesApp(
    navController: NavHostController = rememberNavController()
) {
    val list: List<Note> = listOf(
        Note(
            title = "Shopping list:",
            content = "Soap\nDetergent\nFabric conditioner\nMilk\nSnacks"
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
    NavHost(
        navController = navController,
        startDestination = Navigation.HomeScreen.route
    ) {
        composable(
            route = Navigation.HomeScreen.route
        ) {
            HomeScreen(
                parameters = HomeScreenParameters(
                    list = list,
                    onNoteClick = {
                        navController.navigate(
                            Navigation.NoteScreen.route
                        )
                    }
                )
            )
        }
        composable(
            route = Navigation.NoteScreen.route
        ) {
            var menuExpanded by remember {
                mutableStateOf(false)
            }

            NoteScreen(
                generateNoteScreenParameters(
                    note = list[0],
                    menuExpanded = menuExpanded,
                    onClickMenu = {
                        menuExpanded = !menuExpanded
                    },
                    onClickNavigationIcon = {
                        navController.popBackStack()
                    }
                )
            )
        }
    }
}
