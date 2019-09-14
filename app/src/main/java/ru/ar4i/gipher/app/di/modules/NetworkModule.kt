package ru.ar4i.gipher.app.di.modules

import ru.ar4i.gipher.data.network.api.Api
import ru.ar4i.gipher.data.network.api.GiphyApi

class NetworkModule {

    private val applictionModule: ApplicationModule = ApplicationModule()

    private val api: Api = GiphyApi(applictionModule.privideGson())

    fun provideApi(): Api = api
}