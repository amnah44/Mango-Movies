package com.mango.movies.model.repositiory.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val BASE_URL="https://v2.jokeapi.dev/"  ??
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService= retrofit.create(MovieApiService::class.java)
}