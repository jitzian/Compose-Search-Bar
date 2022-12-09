package com.example.rocketgiant.data.remote.model

import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("api_detail_url")
    val apiDetailUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("site_detail_url")
    val siteDetailUrl: String
)