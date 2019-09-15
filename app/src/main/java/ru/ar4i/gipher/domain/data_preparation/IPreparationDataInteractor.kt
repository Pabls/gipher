package ru.ar4i.gipher.domain.data_preparation

interface IPreparationDataInteractor {
    suspend fun checkDataAvailability(): Boolean
}