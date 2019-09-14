package ru.ar4i.gipher.data.network.request

object Urls {
    private const val DOMAIN = "https://api.giphy.com/"
    private const val VERSION = "v1/"
    private const val GIFS = "gifs/"
    private const val SEARCH = "search"
    private const val RANDOM = "random"
    private const val TRENDING = "trending"

    private fun getBaseUrl() = "$DOMAIN$VERSION$GIFS"

    fun getSearchUrl() = "${getBaseUrl()}$SEARCH"

    fun getRandomUrl() = "${getBaseUrl()}$RANDOM"

    fun getTrendingUrl() = "${getBaseUrl()}$TRENDING"
}