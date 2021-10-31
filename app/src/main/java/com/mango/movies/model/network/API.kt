package com.mango.movies.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val BASE_URL="https://api.themoviedb.org/3/"
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: MovieApiService = retrofit.create(MovieApiService::class.java)
}