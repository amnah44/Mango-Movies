package com.mango.movies.model.domain.movie.topRated

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTopRatedResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val movieTopRatedResults: List<MovieTopRatedResult>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
): Parcelable