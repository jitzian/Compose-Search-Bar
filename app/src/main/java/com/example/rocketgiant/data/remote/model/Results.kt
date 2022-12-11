package com.example.rocketgiant.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Results(
    @SerializedName("aliases")
    val aliases: String? = "",
    @SerializedName("api_detail_url")
    val apiDetailUrl: String? = "",
    @SerializedName("characters")
    val characters: List<Character>? = listOf(),
    @SerializedName("concepts")
    val concepts: List<Concept>? = listOf(),
    @SerializedName("date_added")
    val dateAdded: String? = "",
    @SerializedName("date_last_updated")
    val dateLastUpdated: String? = "",
    @SerializedName("deck")
    val deck: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("developers")
    val developers: List<Developer>? = listOf(),
    @SerializedName("expected_release_day")
    val expectedReleaseDay: String? = "",
    @SerializedName("expected_release_month")
    val expectedReleaseMonth: String? = "",
    @SerializedName("expected_release_quarter")
    val expectedReleaseQuarter: Int? = 0,
    @SerializedName("expected_release_year")
    val expectedReleaseYear: Int? = 0,
    @SerializedName("first_appearance_characters")
    val firstAppearanceCharacters: List<FirstAppearanceCharacter>? = listOf(),
    @SerializedName("first_appearance_concepts")
    val firstAppearanceConcepts: List<FirstAppearanceConcept>? = listOf(),
    @SerializedName("first_appearance_locations")
    val firstAppearanceLocations: List<FirstAppearanceLocation>? = listOf(),
    @SerializedName("first_appearance_objects")
    val firstAppearanceObjects: List<FirstAppearanceObject>? = listOf(),
    @SerializedName("first_appearance_people")
    val firstAppearancePeople: List<FirstAppearancePeople>? = listOf(),
    @SerializedName("franchises")
    val franchises: List<Franchise>? = listOf(),
    @SerializedName("genres")
    val genres: List<Genre>? = listOf(),
    @SerializedName("guid")
    val guid: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: ImageX? = ImageX(),
    @SerializedName("image_tags")
    val imageTags: List<ImageTagX>? = listOf(),
    @SerializedName("images")
    val images: List<ImageXX>? = listOf(),
    @SerializedName("locations")
    val locations: List<Location>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("number_of_user_reviews")
    val numberOfUserReviews: Int? = 0,
    @SerializedName("objects")
    val objects: List<Object>? = listOf(),
    @SerializedName("original_game_rating")
    val originalGameRating: List<OriginalGameRatingX>? = listOf(),
    @SerializedName("original_release_date")
    val originalReleaseDate: String? = "",
    @SerializedName("people")
    val people: List<People>? = listOf(),
    @SerializedName("platforms")
    val platforms: List<PlatformX>? = listOf(),
    @SerializedName("publishers")
    val publishers: List<Publisher>? = listOf(),
    @SerializedName("releases")
    val releases: List<Release>? = listOf(),
    @SerializedName("similar_games")
    val similarGames: List<SimilarGame>? = listOf(),
    @SerializedName("site_detail_url")
    val siteDetailUrl: String? = "",
    @SerializedName("videos")
    val videos: List<Video>? = listOf()
) : Parcelable