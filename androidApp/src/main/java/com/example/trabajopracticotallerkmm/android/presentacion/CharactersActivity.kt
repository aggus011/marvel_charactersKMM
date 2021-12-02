package com.example.trabajopracticotallerkmm.android.presentacion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trabajopracticotallerkmm.android.databinding.ActivityMainBinding
import com.example.trabajopracticotallerkmm.model.Characters
import kotlinx.coroutines.flow.collect


import kotlinx.coroutines.launch


class CharactersActivity : AppCompatActivity() {

    private lateinit var charactersAdapter: CharactersAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup del listado
        charactersAdapter = CharactersAdapter()
        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        with(binding.charactersList) {
            this.adapter = charactersAdapter
            this.layoutManager = verticalLayoutManager
            this.addItemDecoration(VerticalSpaceItemDecoration(16))
        }


        // Listen to Retrofit response
        val viewModel =
             ViewModelProvider(this, CharactersViewModelFactory())[CharactersViewModel::class.java]

         lifecycleScope.launch {
             repeatOnLifecycle(Lifecycle.State.CREATED) {
                 viewModel.screenState.collect{
                     when (it) {
                         ScreenState.Loading -> showLoading()
                         is ScreenState.ShowCharacters -> showCharacters(it.list)
                     }
                 }
             }
         }
    }

    private fun showLoading() {

    }

    private fun showCharacters(list: List<Characters>) {
        charactersAdapter.submitList(list)
    }

}


