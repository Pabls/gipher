package ru.ar4i.gipher.presentation.base.presenter

import ru.ar4i.gipher.presentation.base.view.IMvpView

interface IBasePresenter<V : IMvpView> {
    fun attachView(view: V?)
    fun detachView()
    fun getView(): V?
}