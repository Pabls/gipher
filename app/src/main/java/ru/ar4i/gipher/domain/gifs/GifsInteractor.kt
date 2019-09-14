package ru.ar4i.gipher.domain.gifs

import ru.ar4i.gipher.domain.repositories.IGifsRepository

class GifsInteractor(private val repository: IGifsRepository) :
    IGifsInteractor {

    override suspend fun getTrendingGifs(): List<String> {
        return repository.getTrendingGifs()
    }

    override suspend fun getGifsByQuery(query: String): List<String> {
        return repository.getGifsByQuery(query)
    }
}