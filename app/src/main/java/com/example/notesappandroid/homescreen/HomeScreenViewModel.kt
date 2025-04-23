package com.example.notesappandroid.homescreen

import androidx.lifecycle.ViewModel
import com.example.notesappandroid.db.NotesDao
import com.example.notesappandroid.db.NotesDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val database: NotesDao
): ViewModel() {
    private val _uiState = MutableStateFlow(RetrieveNotesResult.Nothing)
    val uiState: StateFlow<RetrieveNotesResult> = _uiState

    init {
        // TODO: update _uiState with getAllNotes form DB.
    }
}
