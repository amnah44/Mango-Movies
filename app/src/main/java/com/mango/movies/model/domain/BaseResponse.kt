package com.mango.movies.model.domain

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val movieResult: List<T>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
)
