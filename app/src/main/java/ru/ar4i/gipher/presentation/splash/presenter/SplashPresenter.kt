package ru.ar4i.gipher.presentation.splash.presenter

import ru.ar4i.gipher.domain.IGifsInteractor
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.splash.view.ISplashView

class SplashPresenter(private val gifsInteractor: IGifsInteractor) : BasePresenter<ISplashView>() {
}