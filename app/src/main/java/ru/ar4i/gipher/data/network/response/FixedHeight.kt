import com.google.gson.annotations.SerializedName

data class FixedHeight (

	@SerializedName("url") val url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("size") val size : Int,
	@SerializedName("mp4") val mp4 : String,
	@SerializedName("mp4_size") val mp4Size : Int,
	@SerializedName("webp") val webp : String,
	@SerializedName("webp_size") val webpSize : Int
)