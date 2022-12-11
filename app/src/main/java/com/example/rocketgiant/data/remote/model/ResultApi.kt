package com.example.rocketgiant.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultApi(
    @SerializedName("error")
    val error: String,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("number_of_page_results")
    val numberOfPageResults: Int,
    @SerializedName("number_of_total_results")
    val numberOfTotalResults: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("version")
    val version: String
) : Parcelable