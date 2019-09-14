import com.google.gson.annotations.SerializedName

data class Images (

	@SerializedName("fixed_height_still") val fixedHeightStill : FixedHeightStill,
	@SerializedName("original_still") val originalStill : OriginalStill,
	@SerializedName("fixed_width") val fixedWidth : FixedWidth,
	@SerializedName("fixed_height_small_still") val fixedHeightSmallStill : FixedHeightSmallStill,
	@SerializedName("fixed_height_downsampled") val fixedHeightDownsampled : FixedHeightDownsampled,
	@SerializedName("preview") val preview : Preview,
	@SerializedName("fixed_height_small") val fixedHeightSmall : FixedHeightSmall,
	@SerializedName("downsized_still") val downsizedStill : DownsizedStill,
	@SerializedName("downsized") val downsized : Downsized,
	@SerializedName("downsized_large") val downsizedLarge : DownsizedLarge,
	@SerializedName("fixed_width_small_still") val fixedWidthSmallStill : FixedWidthSmallStill,
	@SerializedName("preview_webp") val previewWebp : PreviewWebp,
	@SerializedName("fixed_width_still") val fixedWidthStill : FixedWidthStill,
	@SerializedName("fixed_width_small") val fixedWidthSmall : FixedWidthSmall,
	@SerializedName("downsized_small") val downsizedSmall : DownsizedSmall,
	@SerializedName("fixed_width_downsampled") val fixedWidthDownsampled : FixedWidthDownsampled,
	@SerializedName("downsized_medium") val downsizedMedium : DownsizedMedium,
	@SerializedName("original") val original : Original,
	@SerializedName("fixed_height") val fixedHeight : FixedHeight,
	@SerializedName("looping") val looping : Looping,
	@SerializedName("preview_gif") val previewGif : PreviewGif
)