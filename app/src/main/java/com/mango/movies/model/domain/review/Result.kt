package com.mango.movies.model.domain.review


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("byline")
    val byline: String?,
    @SerializedName("critics_pick")
    val criticsPick: Int?,
    @SerializedName("date_updated")
    val dateUpdated: String?,
    @SerializedName("display_title")
    val displayTitle: String?,
    @SerializedName("headline")
    val headline: String?,
    @SerializedName("link")
    val link: Link?,
    @SerializedName("mpaa_rating")
    val mpaaRating: String?,
    @SerializedName("multimedia")
    val multimedia: Multimedia?,
    @SerializedName("opening_date")
    val openingDate: Any?,
    @SerializedName("publication_date")
    val publicationDate: String?,
    @SerializedName("summary_short")
    val summaryShort: String?
)