package com.mango.movies.model.domain.movie.upComing


import com.google.gson.annotations.SerializedName

data class MovieUpComingResponse(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val movieUpComingResults: List<MovieUpComingResult>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)