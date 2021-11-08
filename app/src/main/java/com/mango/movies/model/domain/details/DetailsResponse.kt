package com.mango.movies.model.domain.details


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.mango.movies.model.domain.genre.Genre

@SuppressLint("ParcelCreator")
data class DetailsResponse(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any?,
    @SerializedName("budget")
    val budget: Int?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("revenue")
    val revenue: Int?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("video")
    val video: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("created_by")
    val createdBy: List<Any>?,
    @SerializedName("episode_run_time")
    val episodeRunTime: List<Int>?,
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @SerializedName("genres")
    val genres: List<Genre>?,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("in_production")
    val inProduction: Boolean?,
    @SerializedName("languages")
    val languages: List<String>?,
    @SerializedName("last_air_date")
    val lastAirDate: String?,
    @SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("networks")
    val networks: List<Network>?,
    @SerializedName("next_episode_to_air")
    val nextEpisodeToAir: Any?,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int?,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int?,
    @SerializedName("origin_country")
    val originCountry: List<String>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompaniesTv: List<Any>?,
    @SerializedName("production_companies")
    val productionCompaniesMovie: List<Network>?,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>?,
    @SerializedName("seasons")
    val seasons: List<Season>?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
    @SerializedName("vote_count")
    val voteCount: Int?
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}