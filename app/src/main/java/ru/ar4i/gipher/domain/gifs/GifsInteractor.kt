package ru.ar4i.gipher.domain.gifs

import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.data.models.GifModel
import ru.ar4i.gipher.domain.repositories.IGifsRepository

class GifsInteractor(private val repository: IGifsRepository) :
    IGifsInteractor {

    override suspend fun getInitialGifs(): List<Gif> {
        return repository.getInitialGifs()
    }

    override suspend fun getTrendingGifs(limit: Int, offset: Int): GifModel {
        return repository.getTrendingGifs(limit, offset)
    }

    override suspend fun getGifsByQuery(query: String, limit: Int, offset: Int): GifModel {
        return repository.getGifsByQuery(query, limit, offset)
    }
}