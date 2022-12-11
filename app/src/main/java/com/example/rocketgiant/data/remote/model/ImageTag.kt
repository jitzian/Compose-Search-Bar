package com.example.rocketgiant.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageTag(
    @SerializedName("api_detail_url")
    val apiDetailUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("total")
    val total: Int
) : Parcelable