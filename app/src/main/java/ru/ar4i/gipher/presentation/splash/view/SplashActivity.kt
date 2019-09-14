package ru.ar4i.gipher.presentation.splash.view

import ru.ar4i.gipher.R
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.base.view.BaseActivity
import ru.ar4i.gipher.presentation.base.view.IMvpView
import ru.ar4i.gipher.presentation.splash.presenter.SplashPresenter

class SplashActivity : BaseActivity(), ISplashView {

    private var presenter: SplashPresenter? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getPresenter(): BasePresenter<IMvpView>? {
        return if (presenter is BasePresenter<*>)
            presenter as BasePresenter<IMvpView>
        else null
    }

    fun setPresenter(presenter: SplashPresenter) {
        this.presenter = presenter
    }

}
