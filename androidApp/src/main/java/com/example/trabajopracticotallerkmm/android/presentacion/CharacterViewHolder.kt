package com.example.trabajopracticotallerkmm.android.presentacion

import androidx.recyclerview.widget.RecyclerView
import com.example.trabajopracticotallerkmm.android.databinding.LayoutItemsBinding
import com.example.trabajopracticotallerkmm.model.Characters


import com.squareup.picasso.Picasso

class CharacterViewHolder(private val binding: LayoutItemsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Characters) {
        binding.name.text = character.name
        binding.description.text = character.description
        if (character.thumbnailUrl.isNotEmpty()) {
            Picasso.Builder(binding.root.context)
                .loggingEnabled(true)
                .build()
                .load(character.thumbnailUrl)
                .into(binding.image)
        } else {
            binding.image.setImageURI(null)
        }
    }

}
