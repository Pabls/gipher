package ru.ar4i.gipher.domain.gifs

import ru.ar4i.gipher.data.models.Gif

interface IGifsInteractor {
    suspend fun getInitialGifs(): List<String>
    suspend fun getTrendingGifs(limit: Int, offset: Int): Gif
    suspend fun getGifsByQuery(query: String, limit: Int, offset: Int): Gif
}