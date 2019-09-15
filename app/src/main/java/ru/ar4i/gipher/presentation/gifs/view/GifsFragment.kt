package ru.ar4i.gipher.presentation.gifs.view

import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import ru.ar4i.gipher.app.App
import ru.ar4i.gipher.presentation.base.presenter.BasePresenter
import ru.ar4i.gipher.presentation.base.view.BaseFragment
import ru.ar4i.gipher.presentation.base.view.IMvpView
import ru.ar4i.gipher.presentation.gifs.presenter.GifsPresenter
import ru.ar4i.gipher.presentation.gifs.view.adapter.GifsAdapter


class GifsFragment : BaseFragment(), GifsView {

    companion object {
        @JvmStatic
        fun newInstance() = GifsFragment()
    }

    private var presenter: GifsPresenter? = null

    private var searchViewEditText: SearchView? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null
    private var tvNoData: TextView? = null
    private var adapter: GifsAdapter? = null
    private var layoutManager: StaggeredGridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(ru.ar4i.gipher.R.menu.search_menu, menu)
        val actionSearch = menu.findItem(ru.ar4i.gipher.R.id.menu_search)
        searchViewEditText = actionSearch?.actionView as SearchView
        searchViewEditText?.queryHint = getString(ru.ar4i.gipher.R.string.menu_search_hint)
        searchViewEditText?.inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
        searchViewEditText?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter?.queryTextChange(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter?.queryTextChange(newText)
                return true
            }
        })
    }

    override fun getLayoutId(): Int {
        return ru.ar4i.gipher.R.layout.fragment_gifs
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

    override fun setItems(urls: List<String>) {
        adapter?.setItems(urls)
        recyclerView?.visibility = View.VISIBLE
        tvNoData?.visibility = View.GONE
    }

    override fun addItems(urls: List<String>) {
        adapter?.addItems(urls)
    }

    override fun showNoDataMessage() {
        recyclerView?.visibility = View.GONE
        tvNoData?.visibility = View.VISIBLE
    }

    fun setPresenter(presenter: GifsPresenter) {
        this.presenter = presenter
    }

    private fun initView(view: View) {
        adapter = GifsAdapter()
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        recyclerView = view.findViewById(ru.ar4i.gipher.R.id.rv_gifs)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        swipeRefreshLayout = view.findViewById(ru.ar4i.gipher.R.id.sr_layout)
        swipeRefreshLayout?.setOnRefreshListener { presenter?.onSwipe() }
        swipeRefreshLayout?.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                this.activity!!,
                ru.ar4i.gipher.R.color.accent
            )
        )

        tvNoData = view.findViewById(ru.ar4i.gipher.R.id.tv_no_data)

        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager?.getItemCount()
                val viewsIds = layoutManager?.findLastVisibleItemPositions(null)
                if (presenter != null &&
                    !presenter?.loadingInProgress()!! &&
                    viewsIds != null &&
                    totalItemCount != null &&
                    (viewsIds.contains(totalItemCount - 20) || viewsIds.contains(totalItemCount))
                ) {
                    presenter?.loadGifs()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }
}
