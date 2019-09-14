package ru.ar4i.gipher.presentation.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter

abstract class BaseFragment : Fragment(), IMvpView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        getPresenter()?.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        getPresenter()?.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    abstract fun getLayoutId(): Int

    abstract fun getPresenter(): BasePresenter<IMvpView>?

    abstract fun inject()
}