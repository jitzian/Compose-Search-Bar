package com.example.rocketgiant.data.remote.model

import com.google.gson.annotations.SerializedName

data class ImageTag(
    @SerializedName("api_detail_url")
    val apiDetailUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("total")
    val total: Int
)