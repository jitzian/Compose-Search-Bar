package com.example.rocketgiant.data.remote.model


import com.google.gson.annotations.SerializedName

data class ImageTagX(
    @SerializedName("api_detail_url")
    val apiDetailUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("total")
    val total: Int? = null
)