package ru.ar4i.gipher.presentation.gifs.presenter

import kotlinx.coroutines.*
import ru.ar4i.gipher.R
import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.data.network.responses.ResponseStatus
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
        private val DELAY = 700L
        private var OFFSET = 0
    }

    private var getDataJob: Job? = null
    private var textChangedJob: Job? = null
    private var paginationLoadingJob: Job? = null
    private var currentSearchQuery: String =
        resourceInteractor.getStringById(R.string.fragment_gifs_text_default_search_query)
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

    fun loadingInProgress(): Boolean {
        return paginationLoadingJob != null && (if (paginationLoadingJob?.isActive != null) return paginationLoadingJob!!.isActive else return false)
    }

    fun loadGifs() {
        if (!currentSearchQuery.isNullOrEmpty())
            paginationLoadingJob = getGifsByPagination()
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
                checkError(gif)
                getView()?.showNoDataMessage()
            } else {
                urls = gif.urls
                getView()?.setItems(gif.urls)
            }
            OFFSET = DEFAULT_OFFSET
        }

    private fun getGifsByPagination() =
        GlobalScope.launch(Dispatchers.Main) {
            OFFSET += DEFAULT_LIMIT
            getView()?.showLoading()
            val gif =
                withContext(Dispatchers.IO) { interactor.getGifsByQuery(currentSearchQuery, DEFAULT_LIMIT, OFFSET) }
            getView()?.hideLoading()
            if (gif.urls.isNotEmpty()) {
                getView()?.addItems(gif.urls)
            } else {
                checkError(gif)
            }
        }

    private fun checkError(gif: Gif) {
        if (gif.meta.status == ResponseStatus.NOT_FOUND.code) {
            getView()?.showError(resourceInteractor.getStringById(R.string.common_check_internet_connection))
        }
    }

    private fun cancelJob() {
        getView()?.hideLoading()
        getDataJob?.cancel()
        textChangedJob?.cancel()
        paginationLoadingJob?.cancel()
    }

    private fun getInitialGifsUrls() = GlobalScope.launch(Dispatchers.Main) {
        getView()?.showLoading()
        urls = withContext(Dispatchers.IO) { interactor.getInitialGifs() }
        getView()?.hideLoading()
        getView()?.setItems(urls)
    }
}