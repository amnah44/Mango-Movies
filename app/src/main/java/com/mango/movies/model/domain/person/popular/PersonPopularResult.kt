package com.mango.movies.model.domain.person.popular


import com.google.gson.annotations.SerializedName

data class PersonPopularResult(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("known_for")
    val knownFor: List<KnownFor>?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
){
    fun getImageUrl() = "https://image.tmdb.org/t/p/w500$profilePath"
}