package com.mango.movies.model.domain.category

import com.google.gson.annotations.SerializedName

data class MovieAndTvDetails(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @SerializedName("genre_ids")
    val genre_ids: List<Int>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("original_language")
    val original_language: String?,
    @SerializedName(value="original_title", alternate=["original_name"])
    val original_title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val poster_path: String?,
    @SerializedName(value="release_date", alternate = ["first_air_date"])
    val release_date: String?,
    @SerializedName(value = "title", alternate = ["name"])
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("vote_average")
    val vote_average: Double?,
    @SerializedName("vote_count")
    val vote_count: Int?
){
    fun getImageUrl() = "https://image.tmdb.org/t/p/w500$poster_path"
}