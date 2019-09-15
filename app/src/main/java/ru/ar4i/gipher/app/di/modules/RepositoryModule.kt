package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.app.App
import ru.ar4i.gipher.data.repositories.GifsRepository
import ru.ar4i.gipher.data.repositories.ResourceRepository
import ru.ar4i.gipher.domain.repositories.IGifsRepository
import ru.ar4i.gipher.domain.repositories.IResourceRepository

class RepositoryModule {

    private val networkModule: NetworkModule = NetworkModule()
    private val dataBaseModule: DataBaseModule = DataBaseModule()

    private val gifsRepository: IGifsRepository =
        GifsRepository(
            networkModule.provideApi(),
            dataBaseModule.provideIUrlsDao()
        )

    private val resourceRepository: IResourceRepository =
        ResourceRepository(App.getContext())

    fun provideGifsRepository(): IGifsRepository = gifsRepository

    fun provideResourceRepository(): IResourceRepository = resourceRepository
}