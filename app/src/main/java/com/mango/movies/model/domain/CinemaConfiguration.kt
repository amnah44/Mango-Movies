package com.mango.movies.model.domain

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class CinemaConfiguration(
    val backdropPath: String?,
    val genreIds: List<Int>?,
    val id: Int?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val name: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val voteAverage: Float?,
    val voteCount: Int?
) : Parcelable {
    override fun describeContents() = 0
    override fun writeToParcel(p0: Parcel?, p1: Int) {
    }
}
