import com.google.gson.annotations.SerializedName

data class DownsizedMedium (
	@SerializedName("url") val url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("size") val size : Int
)