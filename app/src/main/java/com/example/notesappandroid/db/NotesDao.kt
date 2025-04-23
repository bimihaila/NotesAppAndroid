package com.example.notesappandroid.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notesappandroid.note.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert
    fun saveNote(note: NoteEntity)

    @Delete
    fun deleteNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)

    @Query("SELECT * FROM noteentity")
    fun retrieveAllNotes(): Flow<List<Note>>
}
