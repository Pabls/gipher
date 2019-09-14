package ru.ar4i.gipher.domain.data_preparation

import ru.ar4i.gipher.domain.repositories.IGifsRepository

class PreparationDataInteractor(private val repository: IGifsRepository) : IPreparationDataInteractor {
    override suspend fun checkDataAvailability() {
        val hasData = repository.checkDataAvailability()
        if(!hasData){
            val urls = repository.getTrendingGifs()
        }
    }
}