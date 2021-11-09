package com.mango.movies.model.repositiory

import com.mango.movies.model.network.API
import com.mango.movies.model.repositiory.FlowWrapper.wrapWithFlow
import com.mango.movies.util.Constant

object ReviewRepository {
    fun movieReview() = wrapWithFlow {
        API.reviewApiServices.getMovieReviews(Constant.api_key_review)
    }
}