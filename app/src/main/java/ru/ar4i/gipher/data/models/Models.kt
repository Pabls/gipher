package ru.ar4i.gipher.data.models

import ru.ar4i.gipher.data.network.responses.Meta
import ru.ar4i.gipher.data.network.responses.Pagination

data class Gif(
    val urls: List<String>,
    val pagination: Pagination,
    val meta: Meta
)