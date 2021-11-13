package com.mango.movies.model.domain.category

import com.google.gson.annotations.SerializedName
import com.mango.movies.model.domain.category.Result

data class MovieAndTvByGenreResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("total_pages")
    val total_pages: Int?,
    @SerializedName("total_results")
    val total_results: Int?
)