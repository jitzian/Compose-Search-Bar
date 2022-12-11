package com.example.rocketgiant.data.remote.model


import com.google.gson.annotations.SerializedName

data class Concept(
    @SerializedName("api_detail_url")
    val apiDetailUrl: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("site_detail_url")
    val siteDetailUrl: String? = null
)