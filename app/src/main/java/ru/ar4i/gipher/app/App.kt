package ru.ar4i.gipher.app

import android.app.Application
import ru.ar4i.gipher.app.di.components.ApplicationComponent

class App : Application() {

    companion object {
        val component: ApplicationComponent = ApplicationComponent.Implementation()
    }
}