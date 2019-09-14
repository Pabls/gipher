package ru.ar4i.gipher.presentation.gifs.presenter

import ru.ar4i.gipher.domain.gifs.IGifsInteractor
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.gifs.view.GifsView

class GifsPresenter(private val gifsInteractor: IGifsInteractor) : BasePresenter<GifsView>() {
}