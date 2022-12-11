package com.example.rocketgiant.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    @SerializedName("aliases")
    val aliases: String? = "",
    @SerializedName("api_detail_url")
    val apiDetailUrl: String? = "",
    @SerializedName("date_added")
    val dateAdded: String? = "",
    @SerializedName("date_last_updated")
    val dateLastUpdated: String? = "",
    @SerializedName("deck")
    val deck: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("expected_release_day")
    val expectedReleaseDay: String? = null,
    @SerializedName("expected_release_month")
    val expectedReleaseMonth: String? = null,
    @SerializedName("expected_release_quarter")
    val expectedReleaseQuarter: Int? = null,
    @SerializedName("expected_release_year")
    val expectedReleaseYear: Int? = null,
    @SerializedName("guid")
    val guid: String? = "",
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: Image? = null,
    @SerializedName("image_tags")
    val imageTags: List<ImageTag>? = null,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("number_of_user_reviews")
    val numberOfUserReviews: Int? = null,
    @SerializedName("original_game_rating")
    val originalGameRating: List<OriginalGameRating>? = null,
    @SerializedName("original_release_date")
    val originalReleaseDate: String? = "",
    @SerializedName("platforms")
    val platforms: List<Platform>? = null,
    @SerializedName("site_detail_url")
    val siteDetailUrl: String? = ""
) : Parcelable