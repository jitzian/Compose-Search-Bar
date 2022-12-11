package com.example.rocketgiant.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable