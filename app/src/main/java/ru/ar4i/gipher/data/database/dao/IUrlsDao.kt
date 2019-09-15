package ru.ar4i.gipher.data.database.dao

import ru.ar4i.gipher.data.models.Gif

interface IUrlsDao {
    fun insertGifs(gifs: List<Gif>)
    fun selectGifs(): List<Gif>
    fun checkDataAvailability(): Boolean
}