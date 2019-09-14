package ru.ar4i.gipher.domain

interface IGifsRepository {
    fun getTrendingGifs(): List<String>
    fun getGifsByQuery(query: String): List<String>
}