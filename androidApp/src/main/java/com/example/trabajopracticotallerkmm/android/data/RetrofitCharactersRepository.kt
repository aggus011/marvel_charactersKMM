package com.example.trabajopracticotallerkmm.android.data

import com.example.trabajopracticotallerkmm.data.CharactersResponse
import com.example.trabajopracticotallerkmm.model.Characters
import com.example.trabajopracticotallerkmm.model.CharactersRepository


class RetrofitCharactersRepository(private val apiClient: MarvelCharactersClient) :
    CharactersRepository {


    override suspend fun getCharacters(timestamp: Long, md5: String): List<Characters> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    private fun CharactersResponse.toModel(): List<Characters> {
        return this.characters.list.map {
            Characters(it.name, it.description, it.thumbnail.toUrl())
        }
    }

}

