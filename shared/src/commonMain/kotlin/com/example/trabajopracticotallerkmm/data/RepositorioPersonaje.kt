package com.example.trabajopracticotallerkmm.data

import com.example.trabajopracticotallerkmm.initLogger
import com.example.trabajopracticotallerkmm.model.Characters
import com.example.trabajopracticotallerkmm.model.CharactersRepository
import io.github.aakira.napier.Napier
import io.ktor.client.*
//import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*


class RepositorioPersonaje : CharactersRepository {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json{
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }

        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HttpClient", message = message)
                }
            }
            Logger
        }
    }.also {
        initLogger()
    }

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Characters> {


        return httpClient.get<CharactersResponse>() {
            headers {
                append("Accept", "application/json")
            }
            url("https://gateway.marvel.com/v1/public/characters")
            parameter("ts", timestamp)
            parameter("apikey","98634d82e32fb856b57ee08616a6b4c7")
            parameter("hash", md5)

        }.toModel()

    }

    fun CharactersResponse.toModel(): List<Characters> {
        return this.characters.list.map {
            Characters(it.name, it.description, it.thumbnail.toUrl())
        }
    }





}











