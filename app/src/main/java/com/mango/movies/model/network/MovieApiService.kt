package com.mango.movies.model.network

import com.mango.movies.model.domain.movie.details.MovieDetailsResponse
import com.mango.movies.model.domain.movie.latest.MovieLatestResponse
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResponse
import com.mango.movies.model.domain.movie.popular.MoviePopularResponse
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResponse
import com.mango.movies.model.domain.movie.upComing.MovieUpComingResponse
import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.domain.searchResponse.SearchResponse
import com.mango.movies.model.domain.tv.details.TvDetailsResponse
import com.mango.movies.model.domain.tv.latest.TvLatestResponse
import com.mango.movies.model.domain.tv.popular.TvPopularResponse
import com.mango.movies.model.domain.tv.topRated.TvTopRatedResponse
import com.mango.movies.util.Constant
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constant.api_key,
    ): Response<MovieDetailsResponse>

    @GET("movie/latest")
    suspend fun getLatestMovies(@Query("api_key") apiKey: String = Constant.api_key): Response<MovieLatestResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String = Constant.api_key): Response<MovieNowPlayingResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String = Constant.api_key): Response<MoviePopularResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String = Constant.api_key): Response<MovieTopRatedResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String = Constant.api_key): Response<MovieUpComingResponse>

    @GET("person/{person_id}")
    suspend fun getPersonDetails(
        @Path("person_id") personId: Int,
        @Query("api_key") apiKey: String = Constant.api_key,
    ): Response<PersonDetailsResponse>


    @GET("person/popular")
    suspend fun getPersonPopular(@Query("api_key") apiKey: String = Constant.api_key): Response<PersonPopularResponse>

    @GET("tv/{tv_id}")
    suspend fun getTvShowDetails(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = Constant.api_key
    ): Response<TvDetailsResponse>

    @GET("tv/latest")
    suspend fun getLatestTvShow(@Query("api_key") apiKey: String = Constant.api_key): Response<TvLatestResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey: String = Constant.api_key): Response<TvPopularResponse>

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShow(@Query("api_key") apiKey: String = Constant.api_key): Response<TvTopRatedResponse>

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = Constant.api_key,
    ): Response<SearchResponse>


}