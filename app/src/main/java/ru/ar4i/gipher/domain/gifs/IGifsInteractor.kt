package ru.ar4i.gipher.domain.gifs

interface IGifsInteractor {
    suspend fun getTrendingGifs(): List<String>
    suspend fun getGifsByQuery(query: String): List<String>
}