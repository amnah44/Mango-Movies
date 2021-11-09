package com.mango.movies.ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.repositiory.ReviewRepository

class ReviewViewModel: ViewModel(), ReviewInteractionListener {
    val review = ReviewRepository.movieReview().asLiveData()
}