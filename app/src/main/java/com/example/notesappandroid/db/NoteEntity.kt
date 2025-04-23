package com.example.notesappandroid.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteentity")
data class NoteEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "title")
    val title: String? = "",
    @ColumnInfo(name = "content")
    val content: String
)
