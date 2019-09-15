package ru.ar4i.gipher.data.repositories

import ru.ar4i.gipher.data.database.dao.IUrlsDao
import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.data.network.api.Api
import ru.ar4i.gipher.data.network.responses.ApiResponse
import ru.ar4i.gipher.data.network.responses.Meta
import ru.ar4i.gipher.data.network.responses.Pagination
import ru.ar4i.gipher.data.network.responses.ResponseStatus
import ru.ar4i.gipher.domain.repositories.IGifsRepository

class GifsRepository(private val api: Api, private val urlsDao: IUrlsDao) : IGifsRepository {

    override fun getTrendingGifs(limit: Int, offset: Int): Gif {
        val response = api.getTrendingGifs(limit, offset)
        return createGif(response)
    }

    override fun getGifsByQuery(query: String, limit: Int, offset: Int): Gif {
        val response = api.getGifsByQuery(query, limit, offset)
        return createGif(response)
    }

    override fun checkDataAvailability(): Boolean {
        return urlsDao.checkDataAvailability()
    }

    override fun getInitialGifs(): List<String> {
        return urlsDao.selectUrls()
    }

    private fun createGif(response: ApiResponse?): Gif =
        Gif(getUrlsFromResponse(response), getPaginationFromResponse(response), getMetaFromResponse(response))


    private fun getUrlsFromResponse(apiResponse: ApiResponse?): List<String> {
        val urls = if (apiResponse?.data == null || apiResponse.data.isEmpty()) {
            listOf<String>()
        } else {
            apiResponse.data.map { it.images.original.url }
        }
        saveUrls(urls)
        return urls
    }

    private fun getPaginationFromResponse(apiResponse: ApiResponse?): Pagination {
        return if (apiResponse?.pagination != null) {
            apiResponse.pagination
        } else {
            Pagination(0, 0, 0)
        }
    }

    private fun getMetaFromResponse(apiResponse: ApiResponse?): Meta {
        return if (apiResponse?.meta != null) {
            apiResponse.meta
        } else {
            Meta(ResponseStatus.NOT_FOUND.code, null, null)
        }
    }

    private fun saveUrls(urls: List<String>) {
        if (urls.isNotEmpty() && urls.size >= 20) {
            urlsDao.insertUrls(urls)
        }
    }
}