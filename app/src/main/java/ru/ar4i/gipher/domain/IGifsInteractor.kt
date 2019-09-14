package ru.ar4i.gipher.domain

interface IGifsInteractor {
    fun getTrendingGifs(): List<String>
    fun getGifsByQuery(query: String): List<String>
}