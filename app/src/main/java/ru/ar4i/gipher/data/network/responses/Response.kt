package ru.ar4i.gipher.data.network.responses

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data") val data: List<Data>?,
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("meta") val meta: Meta
)

data class Data(
    @SerializedName("type") val type: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("bitly_gif_url") val bitlyGifUrl: String?,
    @SerializedName("bitly_url") val bitlyUrl: String?,
    @SerializedName("embed_url") val embedUrl: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("source") val source: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("content_url") val contentUrl: String?,
    @SerializedName("source_tld") val sourceTld: String?,
    @SerializedName("source_post_url") val sourcePostUrl: String?,
    @SerializedName("is_sticker") val isSticker: Int,
    @SerializedName("import_datetime") val importDatetime: String?,
    @SerializedName("trending_datetime") val trendingDatetime: String?,
    @SerializedName("images") val images: Images,
    @SerializedName("title") val title: String?
)

data class Downsized(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class DownsizedLarge(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class DownsizedMedium(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class DownsizedSmall(
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4Size: Int
)

data class DownsizedStill(

    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class FixedHeight(

    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4Size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webpSize: Int
)

data class FixedHeightDownsampled(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webpSize: Int
)

data class FixedHeightSmall(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4Size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webpSize: Int
)

data class FixedHeightSmallStill(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class FixedHeightStill(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class FixedWidth(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4_size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webp_size: Int
)

data class FixedWidthDownsampled(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webp_size: Int
)

data class FixedWidthSmall(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4_size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webp_size: Int
)

data class FixedWidthSmallStill(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class FixedWidthStill(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class Images(
    @SerializedName("fixed_height_small_still") val fixedHeightSmallStill: FixedHeightSmallStill,
    @SerializedName("original") val original: Original,
    @SerializedName("preview_gif") val previewGif: PreviewGif
)

data class Looping(
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4Size: Int
)

data class Meta(
    @SerializedName("status") val status: Int,
    @SerializedName("msg") val msg: String?,
    @SerializedName("response_id") val responseId: String?
)

data class Original(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("frames") val frames: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4Size: Int,
    @SerializedName("webp") val webp: String?,
    @SerializedName("webp_size") val webpSize: Int,
    @SerializedName("hash") val hash: String?
)

data class OriginalStill(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class Pagination(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("offset") val offset: Int
)

data class Preview(
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("mp4") val mp4: String?,
    @SerializedName("mp4_size") val mp4_size: Int
)

data class PreviewGif(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

data class PreviewWebp(
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("size") val size: Int
)

enum class ResponseStatus(val code: Int) {
    OK(200),
    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_FOUND(404),
    TOO_MANY_REQUESTS(429)
}