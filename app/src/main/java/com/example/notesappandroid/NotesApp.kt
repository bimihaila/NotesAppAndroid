package com.example.notesappandroid

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappandroid.homescreen.HomeScreen
import com.example.notesappandroid.homescreen.HomeScreenParameters
import com.example.notesappandroid.navigation.Navigation

@Composable
fun NotesApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = rememberNavController(), startDestination = Navigation.HomeScreen.route) {
        composable(
            Navigation.HomeScreen.route
        ) {
            HomeScreen(
                parameters = HomeScreenParameters(
                    title = "Hello"
                )
            )
        }
    }
}