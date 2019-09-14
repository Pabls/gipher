package ru.ar4i.gipher.presentation.base.presenter

import ru.ar4i.gipher.presentation.base.view.IMvpView

open class BasePresenter<V : IMvpView> : IBasePresenter<V> {

    private var view: V? = null

    override fun attachView(view: V?) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun getView(): V? {
        return view
    }
}