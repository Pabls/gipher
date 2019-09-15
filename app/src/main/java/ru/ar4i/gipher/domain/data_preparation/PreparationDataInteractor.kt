package ru.ar4i.gipher.domain.data_preparation

import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.domain.repositories.IGifsRepository

class PreparationDataInteractor(private val repository: IGifsRepository) : IPreparationDataInteractor {

    companion object {
        const val LIMIT = 40
        const val OFFSET = 0
    }

    override suspend fun checkDataAvailability(): Boolean {
        val hasData = repository.checkDataAvailability()
        return if (!hasData) {
            val result: Gif = repository.getTrendingGifs(LIMIT, OFFSET)
            result.urls.isNotEmpty()
        } else {
            hasData
        }
    }
}