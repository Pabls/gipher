package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.presentation.gifs.presenter.GifsPresenter
import ru.ar4i.gipher.presentation.splash.presenter.SplashPresenter

class PresenterModule {

    private val interactorModule: InteractorModule = InteractorModule()

    fun provideSplashPresenter(): SplashPresenter =
        SplashPresenter(interactorModule.providePreparationDataInteractor(), interactorModule.provideResourceInteractor())

    fun provideGifsPresenter(): GifsPresenter =
        GifsPresenter(interactorModule.provideGifsInteractor(), interactorModule.provideResourceInteractor())
}