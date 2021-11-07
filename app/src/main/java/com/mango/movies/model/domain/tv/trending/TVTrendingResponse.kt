package com.mango.movies.model.domain.tv.trending


import com.google.gson.annotations.SerializedName

data class TVTrendingResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<TVTrendingResult>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)