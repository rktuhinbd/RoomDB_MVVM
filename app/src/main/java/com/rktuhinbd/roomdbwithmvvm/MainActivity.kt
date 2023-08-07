package com.rktuhinbd.roomdbwithmvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.GsonBuilder
import com.rktuhinbd.roomdbwithmvvm.databinding.ActivityMainBinding
import com.rktuhinbd.roomdbwithmvvm.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteViewModel.allNotes.observe(this, Observer { notes ->
            // Update your RecyclerView adapter with notes data
            Log.d("TAG_", "onCreate: ${GsonBuilder().setPrettyPrinting().create().toJson(notes)}")
        })
    }
}