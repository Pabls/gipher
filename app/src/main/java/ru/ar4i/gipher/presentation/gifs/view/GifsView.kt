package ru.ar4i.gipher.presentation.gifs.view

import ru.ar4i.gipher.presentation.base.view.IMvpView

interface GifsView : IMvpView {
    fun setItems(urls: List<String>)
    fun addItems(urls: List<String>)
    fun showNoDataMessage()
}