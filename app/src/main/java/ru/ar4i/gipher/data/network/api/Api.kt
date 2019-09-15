package ru.ar4i.gipher.data.network.api

import ru.ar4i.gipher.data.network.responses.ApiResponse

interface Api {
    fun getTrendingGifs(limit: Int, offset: Int): ApiResponse?
    fun getGifsByQuery(query: String, limit: Int, offset: Int): ApiResponse?
}