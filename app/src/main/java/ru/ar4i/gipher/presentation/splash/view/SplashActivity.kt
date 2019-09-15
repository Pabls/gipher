package ru.ar4i.gipher.presentation.splash.view

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ru.ar4i.gipher.R
import ru.ar4i.gipher.app.App
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.base.view.BaseActivity
import ru.ar4i.gipher.presentation.base.view.IMvpView
import ru.ar4i.gipher.presentation.main.MainActivity
import ru.ar4i.gipher.presentation.splash.presenter.SplashPresenter

class SplashActivity : BaseActivity(), ISplashView {

    private var presenter: SplashPresenter? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getPresenter(): BasePresenter<IMvpView>? {
        return if (presenter is BasePresenter<*>)
            presenter as BasePresenter<IMvpView>
        else null
    }

    override fun inject() {
        App.getComponent().inject(this)
    }

    override fun showLoading() {
        swipeRefreshLayout?.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout?.isRefreshing = false
    }

    override fun navigateToMain() {
        startActivity(MainActivity.getStartIntent(this))
    }

    fun setPresenter(presenter: SplashPresenter) {
        this.presenter = presenter
    }

    private fun initView() {
        swipeRefreshLayout = findViewById(R.id.sr_layout)
        swipeRefreshLayout?.setOnRefreshListener { presenter?.onSwipe() }
        swipeRefreshLayout?.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this, R.color.accent))
    }
}
