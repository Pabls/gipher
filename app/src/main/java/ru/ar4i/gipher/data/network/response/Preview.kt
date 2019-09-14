import com.google.gson.annotations.SerializedName

data class Preview (

	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("mp4") val mp4 : String,
	@SerializedName("mp4_size") val mp4_size : Int
)