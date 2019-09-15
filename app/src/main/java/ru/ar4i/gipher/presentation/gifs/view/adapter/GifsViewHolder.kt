package ru.ar4i.gipher.presentation.gifs.view.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.ar4i.gipher.R

class GifsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var imgGif: ImageView

    init {
        imgGif = view.findViewById(R.id.img_gif)
    }

    fun bind(url: String) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_error)
            .into(imgGif)
    }
}