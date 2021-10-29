package com.mango.movies.model.repositiory.domain.movie.upComing


import com.google.gson.annotations.SerializedName

data class MovieUpComing(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)