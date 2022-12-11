package com.example.rocketgiant.data.remote.model


import com.google.gson.annotations.SerializedName

data class ImageX(
    @SerializedName("icon_url")
    val iconUrl: String? = null,
    @SerializedName("image_tags")
    val imageTags: String? = null,
    @SerializedName("medium_url")
    val mediumUrl: String? = null,
    @SerializedName("original_url")
    val originalUrl: String? = null,
    @SerializedName("screen_large_url")
    val screenLargeUrl: String? = null,
    @SerializedName("screen_url")
    val screenUrl: String? = null,
    @SerializedName("small_url")
    val smallUrl: String? = null,
    @SerializedName("super_url")
    val superUrl: String? = null,
    @SerializedName("thumb_url")
    val thumbUrl: String? = null,
    @SerializedName("tiny_url")
    val tinyUrl: String? = null
)