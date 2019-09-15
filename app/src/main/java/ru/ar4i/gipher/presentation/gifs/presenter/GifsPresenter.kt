package ru.ar4i.gipher.presentation.gifs.presenter

import kotlinx.coroutines.*
import ru.ar4i.gipher.R
import ru.ar4i.gipher.domain.gifs.IGifsInteractor
import ru.ar4i.gipher.domain.resources.IResourceInteractor
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.gifs.view.GifsView

class GifsPresenter(
    private val interactor: IGifsInteractor,
    private val resourceInteractor: IResourceInteractor
) : BasePresenter<GifsView>() {

    companion object {
        private val MIN_SEARCH_STRING_LENGTH = 2
        private val DEFAULT_LIMIT = 40
        private val DEFAULT_OFFSET = 0
        private val DELAY = 800L
        private var OFFSET = 0
    }

    private var getDataJob: Job? = null
    private var textChangedJob: Job? = null
    private var currentSearchQuery: String = resourceInteractor.getStringById(R.string.common_empty)
    private var searchQueryForPagination: String = resourceInteractor.getStringById(R.string.common_empty)
    private var urls: List<String> = ArrayList()

    override fun attachView(view: GifsView?) {
        super.attachView(view)
        startInitialJob()
    }

    override fun detachView() {
        cancelJob()
        super.detachView()
    }

    fun onSwipe() {
        cancelJob()
        if (urls.isNotEmpty()) {
            getView()?.setItems(urls)
        } else {
            startInitialJob()
        }
    }

    fun queryTextChange(query: String?) {
        if (query != null) {
            if (query.length > MIN_SEARCH_STRING_LENGTH && query != currentSearchQuery) {
                currentSearchQuery = query
                textChangedJob?.cancel()
                textChangedJob = getGifsByName(query)
            } else if (query.isEmpty()) {
                getView()?.setItems(urls)
            }
        }
    }

    private fun startInitialJob() {
        getDataJob = getInitialGifsUrls()
    }

    private fun getGifsByName(query: String) =
        GlobalScope.launch(Dispatchers.Main) {
            delay(DELAY)
            getView()?.showLoading()
            val gif = withContext(Dispatchers.IO) { interactor.getGifsByQuery(query, DEFAULT_LIMIT, DEFAULT_OFFSET) }
            getView()?.hideLoading()
            if (gif.urls.isEmpty()) {
                getView()?.showNoDataMessage()
            } else {
                urls = gif.urls
                getView()?.setItems(gif.urls)
            }
            OFFSET = 0
        }

    private fun getGifsByPagination() =
        GlobalScope.launch(Dispatchers.Main) {
            OFFSET += DEFAULT_LIMIT
            val gif = withContext(Dispatchers.IO) {
                interactor.getGifsByQuery(
                    currentSearchQuery,
                    DEFAULT_LIMIT,
                    OFFSET
                )
            }
            if (gif.urls.isNotEmpty()) {
                getView()?.addItems(gif.urls)
            }
        }

    private fun cancelJob() {
        getView()?.hideLoading()
        getDataJob?.cancel()
        textChangedJob?.cancel()
    }

    private fun getInitialGifsUrls() = GlobalScope.launch(Dispatchers.Main) {
        getView()?.showLoading()
        urls = withContext(Dispatchers.IO) { interactor.getInitialGifs() }
        getView()?.hideLoading()
        getView()?.setItems(urls)
    }
}