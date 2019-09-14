import com.google.gson.annotations.SerializedName

data class FixedHeightDownsampled (

	@SerializedName("url") val url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("size") val size : Int,
	@SerializedName("webp") val webp : String,
	@SerializedName("webp_size") val webpSize : Int
)