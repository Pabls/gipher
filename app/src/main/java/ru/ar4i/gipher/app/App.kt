package ru.ar4i.gipher.app

import android.app.Application
import android.content.Context
import ru.ar4i.gipher.app.di.components.ApplicationComponent

class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null
        private var component: ApplicationComponent? = null
        fun getContext(): Context = instance!!.applicationContext
        fun getComponent(): ApplicationComponent = component!!
    }

    override fun onCreate() {
        super.onCreate()
        component = ApplicationComponent.Implementation()
    }

}