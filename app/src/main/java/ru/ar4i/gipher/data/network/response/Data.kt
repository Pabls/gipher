import com.google.gson.annotations.SerializedName

data class Data (
	@SerializedName("type") val type : String,
	@SerializedName("id") val id : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("url") val url : String,
	@SerializedName("bitly_gif_url") val bitlyGifUrl : String,
	@SerializedName("bitly_url") val bitlyUrl : String,
	@SerializedName("embed_url") val embedUrl : String,
	@SerializedName("username") val username : String,
	@SerializedName("source") val source : String,
	@SerializedName("rating") val rating : String,
	@SerializedName("content_url") val contentUrl : String,
	@SerializedName("source_tld") val sourceTld : String,
	@SerializedName("source_post_url") val sourcePostUrl : String,
	@SerializedName("is_sticker") val isSticker : Int,
	@SerializedName("import_datetime") val importDatetime : String,
	@SerializedName("trending_datetime") val trendingDatetime : String,
	@SerializedName("images") val images : Images,
	@SerializedName("title") val title : String
)