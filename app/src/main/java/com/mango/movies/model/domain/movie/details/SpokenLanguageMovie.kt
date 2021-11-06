package com.mango.movies.model.domain.movie.details


import com.google.gson.annotations.SerializedName

data class SpokenLanguageMovie(
    @SerializedName("english_name")
    val englishName: String?,
    @SerializedName("iso_639_1")
    val iso6391: String?,
    @SerializedName("name")
    val name: String?
)