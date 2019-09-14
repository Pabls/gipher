package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.data.repositories.GifsRepository
import ru.ar4i.gipher.domain.repositories.IGifsRepository

class RepositoryModule {

    private val networkModule: NetworkModule = NetworkModule()
    private val dataBaseModule: DataBaseModule = DataBaseModule()

    private val gifsRepository: IGifsRepository =
        GifsRepository(networkModule.provideApi(), dataBaseModule.provideIUrlsDao())

    fun provideGifsRepository(): IGifsRepository = gifsRepository
}