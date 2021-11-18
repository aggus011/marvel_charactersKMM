package com.example.trabajopracticotallerkmm.android.presentacion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trabajopracticotallerkmm.android.data.CharactersService
import com.example.trabajopracticotallerkmm.android.data.PublicKeyInterceptor
import com.example.trabajopracticotallerkmm.data.RepositorioPersonaje
import okhttp3.OkHttpClient

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

       /*val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()


       val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiClient = retrofit.create(MarvelCharactersClient::class.java)
        val charactersApi = RetrofitCharactersRepository(apiClient)*/


        val charactersApi = RepositorioPersonaje()

        val charactersService = CharactersService(charactersApi)

        return CharactersViewModel(charactersService) as T

    }
}