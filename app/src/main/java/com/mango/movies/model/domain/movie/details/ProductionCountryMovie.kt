package com.mango.movies.model.domain.movie.details


import com.google.gson.annotations.SerializedName

data class ProductionCountryMovie(
    @SerializedName("iso_3166_1")
    val iso31661: String?,
    @SerializedName("name")
    val name: String?
)