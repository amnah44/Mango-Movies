package com.mango.movies.model.repositiory

import com.mango.movies.model.domain.review.ReviewResponse
import com.mango.movies.model.network.API
import com.mango.movies.model.repositiory.FlowWrapper.wrapWithFlow
import com.mango.movies.util.Constant
import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow

object ReviewRepository {
    fun movieReview() = wrapWithFlow {
        API.reviewApiServices.getMovieReviews(Constant.api_key_review)
    }

    fun searchMovieReview(query: String): Flow<State<ReviewResponse?>> = wrapWithFlow {
        API.reviewApiServices.searchMovieReviews(query, Constant.api_key_review)
    }
}