package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.app.App
import ru.ar4i.gipher.data.database.DbHelper
import ru.ar4i.gipher.data.database.dao.IUrlsDao
import ru.ar4i.gipher.data.database.dao.UrlsDao

class DataBaseModule {
    private val dbHelper: DbHelper = DbHelper(App.getContext())
    private val urlsDao: IUrlsDao = UrlsDao(dbHelper)

    fun provideIUrlsDao(): IUrlsDao = urlsDao
}