package com.mango.movies.model.domain.review


import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("has_more")
    val hasMore: Boolean?,
    @SerializedName("num_results")
    val numResults: Int?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("status")
    val status: String?
)