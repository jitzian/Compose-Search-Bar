package com.example.rocketgiant.data.remote.model

import com.google.gson.annotations.SerializedName

data class OriginalGameRating(
    @SerializedName("api_detail_url")
    val apiDetailUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)