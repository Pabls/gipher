package ru.ar4i.gipher.presentation.splash.presenter

import kotlinx.coroutines.*
import ru.ar4i.gipher.R
import ru.ar4i.gipher.domain.data_preparation.IPreparationDataInteractor
import ru.ar4i.gipher.domain.resources.IResourceInteractor
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.splash.view.ISplashView

class SplashPresenter(
    private val interactor: IPreparationDataInteractor,
    private val resourceInteractor: IResourceInteractor
) : BasePresenter<ISplashView>() {

    private var checkDataJob: Job? = null

    override fun attachView(view: ISplashView?) {
        super.attachView(view)
        startJob()
    }

    override fun detachView() {
        cancelJob()
        super.detachView()
    }

    fun onSwipe() {
        cancelJob()
        startJob()
    }

    private fun startJob() {
        checkDataJob = getGifsUrls()
    }

    private fun getGifsUrls() = GlobalScope.launch(Dispatchers.Main) {
        getView()?.showLoading()
        val hasData = withContext(Dispatchers.IO) { interactor.checkDataAvailability() }
        getView()?.hideLoading()
        if (hasData) {
            getView()?.navigateToMain()
        } else {
            getView()?.showError(resourceInteractor.getStringById(R.string.common_check_internet_connection))
        }
    }

    private fun cancelJob() {
        checkDataJob?.cancel()
        checkDataJob = null
    }
}