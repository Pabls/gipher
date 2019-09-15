package ru.ar4i.gipher.presentation.gifs.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ar4i.gipher.data.models.Gif


class GifsAdapter : RecyclerView.Adapter<GifsViewHolder>() {

    private var items: MutableList<Gif> = ArrayList()

    fun setItems(list: List<Gif>) {
        this.items.clear()
        this.items.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(list: List<Gif>) {
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
        val gif = items[position]
        holder.bind(gif.url, gif.title)
    }
}