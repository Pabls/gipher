package ru.ar4i.gipher.domain.repositories

interface IGifsRepository {
    fun getTrendingGifs(): List<String>
    fun getGifsByQuery(query: String): List<String>
    fun checkDataAvailability(): Boolean
}