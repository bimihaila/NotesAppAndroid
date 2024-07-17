package com.example.notesappandroid.navigation

sealed class Navigation(val route: String) {
    data object HomeScreen : Navigation("homeScreen")
    data object NoteScreen : Navigation("noteScreen")
}
