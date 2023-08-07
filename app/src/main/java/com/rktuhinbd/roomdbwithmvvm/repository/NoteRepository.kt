package com.rktuhinbd.roomdbwithmvvm.repository

import androidx.lifecycle.LiveData
import com.rktuhinbd.roomdbwithmvvm.db.NoteDao
import com.rktuhinbd.roomdbwithmvvm.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}