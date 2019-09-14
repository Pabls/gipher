package ru.ar4i.gipher.app.di.modules

import com.google.gson.Gson

class ApplicationModule {

    private val gson: Gson = Gson()

    fun privideGson(): Gson = gson
}