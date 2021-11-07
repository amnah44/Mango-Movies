package com.mango.movies.model.domain.tv.topRated


import com.google.gson.annotations.SerializedName

data class TVTopRatingResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TVTopRatedResult>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)