package ru.ar4i.gipher.data.database.tables

import android.content.ContentValues

object Urls {
    private const val TABLE_NAME = "urls"
    private const val ID = "id"
    private const val VALUE = "value"
    private const val CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $VALUE TEXT);"
    private const val GET_URLS = "SELECT * FROM $TABLE_NAME"
    private const val GET_FIRST_URL = "SELECT * FROM $TABLE_NAME LIMIT 1;"
    private const val CLEAR_TABLE = "DELETE FROM $TABLE_NAME"

    fun getTableCreationCommand() = CREATE_TABLE
    fun getUrlsSelectionCommand() = GET_URLS
    fun getFirstUrlSelectionCommand() = GET_FIRST_URL
    fun getTableСleanupСommand() = CLEAR_TABLE
    fun getColumnName() = VALUE
    fun getTableName() = TABLE_NAME

    fun toContentValue(value: String): ContentValues {
        val cv = ContentValues()
        cv.put(VALUE, value)
        return cv
    }
}