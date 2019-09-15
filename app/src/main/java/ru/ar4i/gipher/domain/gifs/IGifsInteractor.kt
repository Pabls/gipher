package ru.ar4i.gipher.domain.gifs

import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.data.models.GifModel

interface IGifsInteractor {
    suspend fun getInitialGifs(): List<Gif>
    suspend fun getTrendingGifs(limit: Int, offset: Int): GifModel
    suspend fun getGifsByQuery(query: String, limit: Int, offset: Int): GifModel
}