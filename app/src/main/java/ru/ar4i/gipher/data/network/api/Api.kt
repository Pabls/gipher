package ru.ar4i.gipher.data.network.api

import ru.ar4i.gipher.data.network.responses.ApiResponse

interface Api {
    fun getTrendingGifs(): ApiResponse?
    fun getGifsByQuery(query: String): ApiResponse?
}