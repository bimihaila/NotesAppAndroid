package com.example.notesappandroid.db

import com.example.notesappandroid.db.utils.EntityConverter.intoEntity
import com.example.notesappandroid.note.Note
import javax.inject.Inject

class NotesOps @Inject constructor(
    private val dao: NotesDao
) {
    fun saveNote(note: Note) {
        dao.saveNote(intoEntity(note))
    }
}
