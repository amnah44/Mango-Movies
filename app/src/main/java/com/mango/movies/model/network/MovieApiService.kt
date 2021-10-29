package com.mango.movies.model.network

import com.mango.movies.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("/movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId:Int ,
        @Query("api_key") apiKey:String = Constant.api_key,
    ) 

    @GET("/movie/latest")
    suspend fun getLatestMovies(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/person/{person_id}")
    suspend fun getPersonDetails(
        @Path("person_id") personId:Int,
        @Query("api_key") apiKey:String=Constant.api_key,
    )

    @GET("/person/popular")
    suspend fun getPersonPopular(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/tv/{tv_id}")
    suspend fun getTvShowDetails(
        @Path("tv_id") tvId:Int,
        @Query("api_key") apiKey:String=Constant.api_key)

    @GET("/tv/latest")
    suspend fun getLatestTvShow(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/tv/popular")
    suspend fun getPopularTvShow(@Query("api_key") apiKey:String=Constant.api_key)

    @GET("/tv/top_rated")
    suspend fun getTopRatedTvShow(@Query("api_key") apiKey:String=Constant.api_key)
}