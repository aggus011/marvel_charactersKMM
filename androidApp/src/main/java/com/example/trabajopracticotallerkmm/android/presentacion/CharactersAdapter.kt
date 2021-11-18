package com.example.trabajopracticotallerkmm.android.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.trabajopracticotallerkmm.android.databinding.LayoutItemsBinding
import com.example.trabajopracticotallerkmm.model.Characters


class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val charactersList = mutableListOf<Characters>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItemAt(position))
    }

    override fun getItemCount() = charactersList.size

    fun submitList(characters: List<Characters>) {
        with(charactersList) {
            clear()
            addAll(characters)
        }
        notifyDataSetChanged()
    }

    private fun getItemAt(position: Int) = charactersList[position]
}