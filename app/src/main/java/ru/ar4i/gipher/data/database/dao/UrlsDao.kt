package ru.ar4i.gipher.data.database.dao

import android.database.Cursor
import ru.ar4i.gipher.data.database.DbHelper
import ru.ar4i.gipher.data.database.tables.Urls
import ru.ar4i.gipher.data.models.Gif

class UrlsDao(private val dbHelper: DbHelper) : IUrlsDao {

    override fun insertGifs(gifs: List<Gif>) {
        try {
            val db = this.dbHelper.writableDatabase
            db.execSQL(Urls.getTableСleanupСommand())
            for (gif in gifs) {
                val cv = Urls.toContentValue(gif.url, gif.title)
                db.insertOrThrow(Urls.getTableName(), null, cv)
            }
            closeConnection()
        } catch (ex: Exception) {
            closeConnection()
        }
    }

    override fun selectGifs(): List<Gif> {
        val gifs = mutableListOf<Gif>()
        var cursor: Cursor? = null
        try {
            val db = this.dbHelper.writableDatabase
            cursor = db.rawQuery(Urls.getUrlsSelectionCommand(), null)
            if (cursor != null && cursor.moveToFirst()) {
                while (!cursor.isAfterLast) {
                    val value = cursor.getString(cursor.getColumnIndex(Urls.getValueColumnName()))
                    val title = cursor.getString(cursor.getColumnIndex(Urls.getTitleColumnName()))
                    gifs.add(Gif(title, value))
                    cursor.moveToNext()
                }
            }
            closeCursor(cursor)
            closeConnection()
            return gifs
        } catch (ex: Exception) {
            closeCursor(cursor)
            closeConnection()
            return gifs
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