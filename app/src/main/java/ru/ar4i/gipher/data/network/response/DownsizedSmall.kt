import com.google.gson.annotations.SerializedName

data class DownsizedSmall (

	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("mp4") val mp4 : String,
	@SerializedName("mp4_size") val mp4Size : Int
)