package com.mango.movies.model.domain.searchResponse


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResponse(
    @SerializedName("page")
    var page: Int? = 0,
    @SerializedName("results")
    var results: List<Result>? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = 0,
    @SerializedName("total_results")
    var totalResults: Int? = 0
): Parcelable