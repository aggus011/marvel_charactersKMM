package com.example.trabajopracticotallerkmm.android.presentacion

import com.example.trabajopracticotallerkmm.model.Characters

sealed class ScreenState {

    object Loading : ScreenState()

    class ShowCharacters(val list: List<Characters>) : ScreenState()
}