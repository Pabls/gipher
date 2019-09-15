package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.domain.data_preparation.IPreparationDataInteractor
import ru.ar4i.gipher.domain.data_preparation.PreparationDataInteractor
import ru.ar4i.gipher.domain.gifs.GifsInteractor
import ru.ar4i.gipher.domain.gifs.IGifsInteractor
import ru.ar4i.gipher.domain.resources.IResourceInteractor
import ru.ar4i.gipher.domain.resources.ResourceInteractor

class InteractorModule {

    private val repositoryModule: RepositoryModule = RepositoryModule()

    private val gifsInteractor: IGifsInteractor = GifsInteractor(repositoryModule.provideGifsRepository())

    private val preparationDataInteractor: IPreparationDataInteractor =
        PreparationDataInteractor(repositoryModule.provideGifsRepository())

    private val resourceInteractor: IResourceInteractor = ResourceInteractor(repositoryModule.provideResourceRepository())

    fun provideGifsInteractor(): IGifsInteractor = gifsInteractor

    fun providePreparationDataInteractor(): IPreparationDataInteractor = preparationDataInteractor

    fun provideResourceInteractor(): IResourceInteractor = resourceInteractor
}