package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.domain.GifsInteractor
import ru.ar4i.gipher.domain.IGifsInteractor

class InteractorModule {

    private val repositoryModule: RepositoryModule = RepositoryModule()

    private val gifsInteractor: IGifsInteractor = GifsInteractor(repositoryModule.provideGifsRepository())

    fun provideGifsInteractor(): IGifsInteractor = gifsInteractor
}