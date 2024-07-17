package com.example.notesappandroid.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notesappandroid.note.Note
import java.util.concurrent.Flow

@Dao
interface NotesDao {
    @Insert
    fun saveNote(note: NotesEntity)

    @Delete
    fun deleteNote(id: String)

//    @Query("SELECT * FROM")
//    fun retrieveAllNotes(): Flow<List<Note>>
}
