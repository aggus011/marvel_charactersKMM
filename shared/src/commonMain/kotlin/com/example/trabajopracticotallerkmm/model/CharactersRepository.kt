package com.example.trabajopracticotallerkmm.model


interface CharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Characters>
}
