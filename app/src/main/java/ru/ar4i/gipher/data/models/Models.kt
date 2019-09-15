package ru.ar4i.gipher.data.models

import ru.ar4i.gipher.data.network.responses.Meta
import ru.ar4i.gipher.data.network.responses.Pagination

data class GifModel(
    val urls: List<Gif>,
    val pagination: Pagination,
    val meta: Meta
)

data class Gif(val title: String, val url: String)