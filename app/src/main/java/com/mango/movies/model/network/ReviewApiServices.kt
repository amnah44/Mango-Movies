package com.mango.movies.model.network

import com.mango.movies.model.domain.review.ReviewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ReviewApiServices {
    @GET("reviews/picks.json")
    suspend fun getMovieReviews(
        @Query("api-key") apiKey: String?
    ):Response<ReviewResponse>

    @GET("reviews/search.json")
    suspend fun searchMovieReviews(
        @Query("query") query: String?,
        @Query("api-key") apiKey: String?
    ): Response<ReviewResponse>
}