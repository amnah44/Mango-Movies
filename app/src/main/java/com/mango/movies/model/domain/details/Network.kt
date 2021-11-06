package com.mango.movies.model.domain.details


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logo_path")
    val logoPathNetworkTv: String?,
    @SerializedName("logo_path")
    val logoPathProductionCompanyMovie: Any?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)