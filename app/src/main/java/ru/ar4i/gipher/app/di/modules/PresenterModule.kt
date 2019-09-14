package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.presentation.gifs.GifsPresenter
import ru.ar4i.gipher.presentation.splash.presenter.SplashPresenter

class PresenterModule {

    private val presenterModule: InteractorModule = InteractorModule()

    fun provideSplashPresenter(): SplashPresenter = SplashPresenter(presenterModule.provideGifsInteractor())

    fun provideGifsPresenter(): GifsPresenter = GifsPresenter(presenterModule.provideGifsInteractor())
}