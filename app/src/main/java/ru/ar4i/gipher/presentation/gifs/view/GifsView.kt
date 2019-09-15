package ru.ar4i.gipher.presentation.gifs.view

import ru.ar4i.gipher.data.models.Gif
import ru.ar4i.gipher.presentation.base.view.IMvpView

interface GifsView : IMvpView {
    fun setItems(urls: List<Gif>)
    fun addItems(urls: List<Gif>)
    fun showNoDataMessage()
}