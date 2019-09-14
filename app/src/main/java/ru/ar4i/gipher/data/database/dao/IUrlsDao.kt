package ru.ar4i.gipher.data.database.dao

interface IUrlsDao {
    fun insertUrls(urls: List<String>)
    fun selectUrls(): List<String>
    fun checkDataAvailability(): Boolean
}