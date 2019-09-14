package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.data.network.api.Api
import ru.ar4i.gipher.data.network.api.GiphyApi
import ru.ar4i.gipher.data.repositories.GifsRepository
import ru.ar4i.gipher.domain.IGifsRepository

class RepositoryModule {

    private val networkModule: NetworkModule = NetworkModule()

    private val gifsRepository: IGifsRepository = GifsRepository(networkModule.provideApi())

    fun provideGifsRepository(): IGifsRepository = gifsRepository
}