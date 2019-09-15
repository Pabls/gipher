package ru.ar4i.gipher.presentation.gifs.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.ar4i.gipher.R

class GifsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var imgGif: ImageView
    private var tvTitle: TextView

    init {
        imgGif = view.findViewById(R.id.img_gif)
        tvTitle = view.findViewById(R.id.tv_title)
    }

    fun bind(url: String, title: String) {
        tvTitle.text = title
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_error)
            .into(imgGif)
    }
}