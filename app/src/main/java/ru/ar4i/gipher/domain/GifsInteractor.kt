package ru.ar4i.gipher.domain

class GifsInteractor(private val repository: IGifsRepository) : IGifsInteractor {

    override fun getTrendingGifs(): List<String> {
        return repository.getTrendingGifs()
    }

    override fun getGifsByQuery(query: String): List<String> {
        return repository.getGifsByQuery(query)
    }
}