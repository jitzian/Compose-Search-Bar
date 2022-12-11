package com.example.rocketgiant.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResulApiSingleGame(
    @SerializedName("error")
    val error: String? = "",
    @SerializedName("limit")
    val limit: Int? = 0,
    @SerializedName("number_of_page_results")
    val numberOfPageResults: Int? = 0,
    @SerializedName("number_of_total_results")
    val numberOfTotalResults: Int? = 0,
    @SerializedName("offset")
    val offset: Int? = 0,
    @SerializedName("results")
    val results: Results? = Results(),
    @SerializedName("status_code")
    val statusCode: Int? = 0,
    @SerializedName("version")
    val version: String? = ""
) : Parcelable