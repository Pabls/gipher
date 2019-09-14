import com.google.gson.annotations.SerializedName

data class ApiResponse (
	@SerializedName("data") val data : List<Data>,
	@SerializedName("pagination") val pagination : Pagination,
	@SerializedName("meta") val meta : Meta
)