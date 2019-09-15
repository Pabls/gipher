package ru.ar4i.gipher.domain.repositories

import ru.ar4i.gipher.data.models.Gif

interface IGifsRepository {
    fun getTrendingGifs(limit: Int, offset: Int): Gif
    fun getGifsByQuery(query: String, limit: Int, offset: Int): Gif
    fun checkDataAvailability(): Boolean
    fun getInitialGifs(): List<String>
}