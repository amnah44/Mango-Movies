package com.mango.movies.model.network

import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.details.DetailsResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.movie.details.MovieDetailsResponse
import com.mango.movies.model.domain.movie.latest.MovieLatestResponse
import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.tv.details.TvDetailsResponse
import com.mango.movies.model.domain.tv.latest.TvLatestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String?,
    ): Response<DetailsResponse>

    @GET("movie/latest")
    suspend fun getLatestMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
    ): Response<BaseResponse<Movie>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String?,
    ): Response<BaseResponse<Movie>>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
    ): Response<BaseResponse<Movie>>

    @GET("person/{person_id}")
    suspend fun getPersonDetails(
        @Path("person_id") personId: Int,
        @Query("api_key") apiKey: String?,
    ): Response<PersonDetailsResponse>

    @GET("tv/{tv_id}")
    suspend fun getTvShowDetails(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String?,
    ): Response<TvDetailsResponse>

    @GET("tv/latest")
    suspend fun getLatestTvShow(
        @Query("api_key") apiKey: String?,
    ): Response<TvLatestResponse>

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(
        @Query("api_key") apiKey: String?,
    ): Response<BaseResponse<Series>>

    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingTV(
        @Path("media_type") mediaType: String?,
        @Path("time_window") timeWindow: String?,
        @Query("api_key") apiKey: String?
    ): Response<BaseResponse<Series>>

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String?,
    ): Response<BaseResponse<Movie>>


    @GET("person/popular")
    suspend fun getPersonPopular(
        @Query("api_key") apiKey: String?,
    ): Response<PersonPopularResponse>


    @GET("genre/movie/list")
    suspend fun getMovieGenre(
        @Query("api_key") apiKey: String?
    ): Response<GenerResponse>

    @GET("genre/tv/list")
    suspend fun getTvGenre(
        @Query("api_key") apiKey: String?
    ): Response<GenerResponse>

    @GET("discover/movie")
    suspend fun getGenreMovie(
        @Query("with_genres") genreId: Int?,
        @Query("api_key") apiKey: String?,
    ): Response<MovieAndTvByGenreResponse>

    @GET("discover/tv")
    suspend fun getGenreTv(
        @Query("with_genres") genreId: Int?,
        @Query("api_key") apiKey: String?,
    ): Response<MovieAndTvByGenreResponse>

}