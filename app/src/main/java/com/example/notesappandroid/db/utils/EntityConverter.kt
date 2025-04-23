package com.example.notesappandroid.db.utils

import com.example.notesappandroid.db.NoteEntity
import com.example.notesappandroid.note.Note
import java.util.UUID

object EntityConverter {
    fun intoEntity(note: Note): NoteEntity {
        return NoteEntity(
            id = UUID.randomUUID().toString(),
            title = note.title,
            content = note.content
        )
    }

    fun NoteEntity.intoNote(noteEntity: NoteEntity): Note {
        return Note(
            id = noteEntity.id,
            title = noteEntity.title,
            content = noteEntity.content
        )
    }
}
