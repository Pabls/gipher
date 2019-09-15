package ru.ar4i.gipher.presentation.gifs.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class GifsAdapter : RecyclerView.Adapter<GifsViewHolder>() {

    private var items: MutableList<String> = ArrayList()

    fun setItems(list: List<String>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(list: List<String>) {
        this.items.addAll(list)
        notifyDataSetChanged()
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
}