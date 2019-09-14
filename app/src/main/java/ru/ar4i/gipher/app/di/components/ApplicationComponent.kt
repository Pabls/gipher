package ru.ar4i.gipher.app.di.components

import ru.ar4i.gipher.app.di.modules.PresenterModule
import ru.ar4i.gipher.presentation.gifs.GifsFragment
import ru.ar4i.gipher.presentation.splash.view.SplashActivity

interface ApplicationComponent {
    fun inject(splashActivity: SplashActivity)
    fun inject(gifsFragment: GifsFragment)

    class Implementation : ApplicationComponent {
        private var presenterModule: PresenterModule = PresenterModule()

        override fun inject(splashActivity: SplashActivity) {
            splashActivity.setPresenter(presenterModule.provideSplashPresenter())
        }

        override fun inject(gifsFragment: GifsFragment) {
            gifsFragment.setPresenter(presenterModule.provideGifsPresenter())
        }
    }
}