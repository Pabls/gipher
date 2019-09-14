package ru.ar4i.gipher.data.repositories

import ru.ar4i.gipher.data.network.api.Api
import ru.ar4i.gipher.domain.IGifsRepository

class GifsRepository(private val api: Api) : IGifsRepository {

    override fun getTrendingGifs(): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGifsByQuery(query: String): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}