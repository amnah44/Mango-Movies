package com.mango.movies.model.domain.genre


import com.google.gson.annotations.SerializedName

data class GenerResponse(
    @SerializedName("genres")
    val genres: List<Genre>?
)