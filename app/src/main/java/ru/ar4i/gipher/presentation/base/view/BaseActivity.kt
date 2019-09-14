package ru.ar4i.gipher.presentation.base.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter

abstract class BaseActivity : AppCompatActivity(), IMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        inject()
        getPresenter()?.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter()?.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    abstract fun getLayoutId(): Int

    abstract fun getPresenter(): BasePresenter<IMvpView>?

    abstract fun inject()

}