package ru.ar4i.gipher.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.ar4i.gipher.data.database.tables.Urls

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, VERSION) {

    companion object {
        private const val VERSION = 1
        private const val DATABASE_NAME = "ru.ar4i.gipher.database"
    }

    override fun onCreate(database: SQLiteDatabase?) {
        try {
            database?.beginTransaction()
            database?.execSQL(Urls.getTableCreationCommand())
            database?.setTransactionSuccessful()
            database?.endTransaction()
        } catch (e: Exception){
            database?.endTransaction()
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}