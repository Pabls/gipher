package ru.ar4i.gipher.data.repositories

import ru.ar4i.gipher.data.database.dao.IUrlsDao
import ru.ar4i.gipher.data.network.api.Api
import ru.ar4i.gipher.data.network.responses.ApiResponse
import ru.ar4i.gipher.domain.repositories.IGifsRepository

class GifsRepository(private val api: Api, private val urlsDao: IUrlsDao) : IGifsRepository {

    override fun getTrendingGifs(): List<String> {
        val response = api.getTrendingGifs()
        return getUrlsFromResponse(response)
    }

    override fun getGifsByQuery(query: String): List<String> {
        val response = api.getGifsByQuery(query)
        return getUrlsFromResponse(response)
    }

    override fun checkDataAvailability(): Boolean {
        return urlsDao.checkDataAvailability()
    }

    private fun getUrlsFromResponse(apiResponse: ApiResponse?): List<String> {
        return if (apiResponse == null || apiResponse.data.isNullOrEmpty()) {
            listOf<String>()
        } else {
            apiResponse.data.map { it.images.previewGif.url }
        }
    }
}