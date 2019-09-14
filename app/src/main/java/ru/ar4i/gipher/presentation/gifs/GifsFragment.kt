package ru.ar4i.gipher.presentation.gifs

import android.os.Bundle
import android.text.InputType
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ru.ar4i.gipher.R
import ru.ar4i.gipher.app.App
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.base.view.BaseFragment
import ru.ar4i.gipher.presentation.base.view.IMvpView


class GifsFragment : BaseFragment(), GifsView {

    companion object {
        @JvmStatic
        fun newInstance() = GifsFragment()
    }

    private var presenter: GifsPresenter? = null

    private var searchViewEditText: SearchView? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_gifs
    }

    override fun getPresenter(): BasePresenter<IMvpView>? {
        return if (presenter is BasePresenter<*>)
            presenter as BasePresenter<IMvpView>
        else null
    }

    override fun inject() {
        App.component.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
        val actionSearch = menu.findItem(R.id.menu_search)
        searchViewEditText = actionSearch?.actionView as SearchView
        searchViewEditText?.queryHint = getString(R.string.menu_search_hint)
        searchViewEditText?.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
        searchViewEditText?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    fun setPresenter(presenter: GifsPresenter) {
        this.presenter = presenter
    }

    private fun initView(view: View) {
        swipeRefreshLayout = view.findViewById(R.id.sr_layout)
        recyclerView = view.findViewById(R.id.rv_gifs)
    }
}
