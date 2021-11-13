package com.mango.movies.model.domain.category

import com.google.gson.annotations.SerializedName

data class Result(
    val adult: Boolean?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val original_language: String?,
    @SerializedName(value="original_title", alternate=["original_name"])
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    @SerializedName(value="release_date", alternate = ["first_air_date"])
    val release_date: String?,
    @SerializedName(value = "title", alternate = ["name"])
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
){
    fun getImageUrl() = "https://image.tmdb.org/t/p/w500$poster_path"
}