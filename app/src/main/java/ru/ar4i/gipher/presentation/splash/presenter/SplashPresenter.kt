package ru.ar4i.gipher.presentation.splash.presenter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ar4i.gipher.domain.data_preparation.IPreparationDataInteractor
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.splash.view.ISplashView

class SplashPresenter(private val interactor: IPreparationDataInteractor) : BasePresenter<ISplashView>() {

    override fun attachView(view: ISplashView?) {
        super.attachView(view)
        getGifsUrls()
    }

    private fun getGifsUrls() = GlobalScope.launch(Dispatchers.Main) {
        withContext(Dispatchers.IO) { interactor.checkDataAvailability() }
        getView()?.navigateToMain()
    }
}