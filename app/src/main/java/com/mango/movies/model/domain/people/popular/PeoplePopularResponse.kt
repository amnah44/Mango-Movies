package com.mango.movies.model.domain.people.popular


import com.google.gson.annotations.SerializedName

data class PeoplePopularResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val peoplePopularResults: List<PeoplePopularResult>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)