package ru.ar4i.gipher.data.network.api

import android.net.Uri
import com.google.gson.Gson
import ru.ar4i.gipher.BuildConfig
import ru.ar4i.gipher.data.network.request.RequestParams
import ru.ar4i.gipher.data.network.request.Urls
import ru.ar4i.gipher.data.network.responses.ApiResponse
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class GiphyApi(private val gson: Gson) : Api {

    override fun getTrendingGifs(limit: Int, offset: Int): ApiResponse? {
        val uri = getUriBuilder(Urls.getTrendingGifsUrl(), limit, offset)?.build()
        return getResponse(uri)
    }

    override fun getGifsByQuery(query: String, limit: Int, offset: Int): ApiResponse? {
        val uri = getUriBuilder(Urls.getSearchStickersUrl(), limit, offset)
            .appendQueryParameter(RequestParams.QUERY, query)
            .build()
        return getResponse(uri)
    }

    private fun getResponse(uri: Uri): ApiResponse? {
        val response = downloadUrl(URL(uri.toString()))
        return try {
            gson.fromJson(response, ApiResponse::class.java)
        } catch (e: Exception) {
            null
        }
    }

    private fun getUriBuilder(url: String, limit: Int, offset: Int): Uri.Builder {
        return Uri.parse(url)
            .buildUpon()
            .appendQueryParameter(RequestParams.API_KEY, BuildConfig.API_KEY)
            .appendQueryParameter(RequestParams.LIMIT, limit.toString())
            .appendQueryParameter(RequestParams.OFFSET, offset.toString())
    }

    private fun downloadUrl(url: URL): String? {
        var connection: HttpsURLConnection? = null
        try {
            return try {
                connection = (url.openConnection() as? HttpsURLConnection)
                connection?.run {
                    readTimeout = BuildConfig.READ_TIMEOUT_MILS
                    connectTimeout = BuildConfig.CONNECT_TIMEOUT_MILS
                    requestMethod = RequestParams.HTTP_GET
                    doInput = true
                    connect()
                    if (responseCode != HttpsURLConnection.HTTP_OK) {
                        throw IOException("$responseCode")
                    }
                    val res = inputStream?.let { stream ->
                        readStream(stream, 10000000)
                    }
                    connection?.inputStream?.close()
                    connection?.disconnect()
                    res
                }
            } catch (e: Exception) {
                connection?.inputStream?.close()
                connection?.disconnect()
                null
            }
        } catch (e: Exception) {
            return null
        }
    }

    fun readStream(stream: InputStream, maxReadSize: Int): String? {
        val reader: Reader? = InputStreamReader(stream, "UTF-8")
        val rawBuffer = CharArray(maxReadSize)
        val buffer = StringBuffer()
        var readSize: Int = reader?.read(rawBuffer) ?: -1
        var maxReadBytes = maxReadSize
        while (readSize != -1 && maxReadBytes > 0) {
            if (readSize > maxReadBytes) {
                readSize = maxReadBytes
            }
            buffer.append(rawBuffer, 0, readSize)
            maxReadBytes -= readSize
            readSize = reader?.read(rawBuffer) ?: -1
        }
        return buffer.toString()
    }
}