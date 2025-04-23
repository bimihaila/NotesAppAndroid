package com.example.notesappandroid.homescreen

sealed class RetrieveNotesResult {
    data object Nothing : RetrieveNotesResult()
    data object Success : RetrieveNotesResult()
    data class Fail(val error: Exception) : RetrieveNotesResult()
}