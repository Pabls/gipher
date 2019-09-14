package ru.ar4i.gipher.data.network.request

object Urls {
    private const val DOMAIN = "https://api.giphy.com/"
    private const val VERSION = "v1/"
    private const val GIFS = "gifs/"
    private const val STICKERS = "stickers/"
    private const val SEARCH = "search"
    private const val RANDOM = "random"
    private const val TRENDING = "trending"

    private fun getBaseUrl() = "$DOMAIN$VERSION"

    fun getSearchGifsUrl() = "${getBaseUrl()}$GIFS$SEARCH"

    fun getRandomGifsUrl() = "${getBaseUrl()}$GIFS$RANDOM"

    fun getTrendingGifsUrl() = "${getBaseUrl()}$GIFS$TRENDING"

    fun getSearchStickersUrl() = "${getBaseUrl()}$STICKERS$SEARCH"

    fun getRandomStickersUrl() = "${getBaseUrl()}$STICKERS$RANDOM"

    fun getTrendingStickersUrl() = "${getBaseUrl()}$STICKERS$TRENDING"
}