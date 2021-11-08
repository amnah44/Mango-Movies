package com.mango.movies.model.domain.celebrity.popular


import com.google.gson.annotations.SerializedName

data class CelebrityResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val peoplePopularResults: List<PersonPopularResult>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)
