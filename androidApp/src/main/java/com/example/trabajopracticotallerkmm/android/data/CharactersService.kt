package com.example.trabajopracticotallerkmm.android.data
import com.example.trabajopracticotallerkmm.android.BuildConfig
import com.example.trabajopracticotallerkmm.data.RepositorioPersonaje
import com.example.trabajopracticotallerkmm.model.Characters
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class CharactersService(
   private val charactersRepository: RepositorioPersonaje
    //private val charactersRepository: RetrofitCharactersRepository
) {

    suspend fun getCharacters(): List<Characters> {
        val timestamp = System.currentTimeMillis()
        return charactersRepository.getCharacters(
            timestamp,
            md5(timestamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY)
        )
    }

    private fun md5(string: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(string.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

}