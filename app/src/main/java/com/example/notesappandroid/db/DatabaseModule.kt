package com.example.notesappandroid.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun initialiseDatabase(
        @ApplicationContext
        context: Context
    ): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java, "notes-db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(
        database: NotesDatabase
    ): NotesDao {
        return database.getDao()
    }
}
