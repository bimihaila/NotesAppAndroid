package com.example.notesappandroid.db

import androidx.room.Database

@Database(entities = [NotesEntity::class], version = 1)
abstract class DatabaseInit {
    abstract fun getDao(): NotesDao
}
