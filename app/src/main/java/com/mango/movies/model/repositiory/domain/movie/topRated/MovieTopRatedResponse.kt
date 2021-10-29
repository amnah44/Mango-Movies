package com.mango.movies.model.repositiory.domain.movie.topRated


import com.google.gson.annotations.SerializedName

data class MovieTopRatedResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)