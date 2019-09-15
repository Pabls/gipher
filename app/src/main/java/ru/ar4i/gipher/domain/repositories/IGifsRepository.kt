package ru.ar4i.gipher.domain.repositories

import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.data.models.GifModel

interface IGifsRepository {
    fun getTrendingGifs(limit: Int, offset: Int): GifModel
    fun getGifsByQuery(query: String, limit: Int, offset: Int): GifModel
    fun checkDataAvailability(): Boolean
    fun getInitialGifs(): List<Gif>
}