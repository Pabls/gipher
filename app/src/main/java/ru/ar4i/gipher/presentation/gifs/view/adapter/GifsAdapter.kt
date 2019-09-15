package ru.ar4i.gipher.presentation.gifs.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class GifsAdapter : RecyclerView.Adapter<GifsViewHolder>() {

    companion object {
        private val diffCallback = UrlsDiffUtilCallback()
    }

    private var items: MutableList<String> = ArrayList()

    fun setItems(list: List<String>) {
        val diffResult = getDiffResult(list)
        clearItems()
        addAllItems(list, diffResult)
    }

    fun addItems(list: List<String>) {
        val diffResult = getDiffResult(list)
        addAllItems(list, diffResult)
    }

    private fun getDiffResult(list: List<String>): DiffUtil.DiffResult {
        diffCallback.setOldList(items)
        diffCallback.setNewList(list)
        return DiffUtil.calculateDiff(diffCallback)
    }

    private fun addAllItems(list: List<String>, diffResult: DiffUtil.DiffResult) {
        this.items.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    fun clearItems() {
        this.items.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(ru.ar4i.gipher.R.layout.item_gif, parent, false)
        return GifsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class UrlsDiffUtilCallback :
        DiffUtil.Callback() {

        private var oldList: List<String> = ArrayList()
        private var newList: List<String> = ArrayList()

        fun setOldList(oldList: List<String>) {
            this.oldList = oldList
        }

        fun setNewList(newList: List<String>) {
            this.newList = newList
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}