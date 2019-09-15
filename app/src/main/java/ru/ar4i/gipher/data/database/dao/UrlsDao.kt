package ru.ar4i.gipher.data.database.dao

import android.database.Cursor
import ru.ar4i.gipher.data.database.DbHelper
import ru.ar4i.gipher.data.database.tables.Urls

class UrlsDao(private val dbHelper: DbHelper) : IUrlsDao {

    override fun insertUrls(urls: List<String>) {
        try {
            val db = this.dbHelper.writableDatabase
            db.execSQL(Urls.getTableСleanupСommand())
            for (url in urls) {
                val cv = Urls.toContentValue(url)
                db.insertOrThrow(Urls.getTableName(), null, cv)
            }
            closeConnection()
        } catch (ex: Exception) {
            closeConnection()
        }
    }

    override fun selectUrls(): List<String> {
        val urls = mutableListOf<String>()
        var cursor: Cursor? = null
        try {
            val db = this.dbHelper.writableDatabase
            cursor = db.rawQuery(Urls.getUrlsSelectionCommand(), null)
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast) {
                    val value = cursor.getString(cursor.getColumnIndex(Urls.getColumnName()))
                    urls.add(value)
                    cursor.moveToNext()
                }
            }
            closeCursor(cursor)
            closeConnection()
            return urls
        } catch (ex: Exception) {
            closeCursor(cursor)
            closeConnection()
            return urls
        }
    }

    override fun checkDataAvailability(): Boolean {
        var cursor: Cursor? = null
        return try {
            val db = this.dbHelper.writableDatabase
            cursor = db.rawQuery(Urls.getFirstUrlSelectionCommand(), null)
            val hasValues = cursor != null && cursor.count > 0
            closeCursor(cursor)
            closeConnection()
            hasValues
        } catch (ex: Exception) {
            closeCursor(cursor)
            closeConnection()
            false
        }
    }

    private fun closeCursor(cursor: Cursor?) {
        if (cursor != null && !cursor.isClosed)
            cursor.close()
    }

    private fun closeConnection() {
        this.dbHelper.close()
    }
}