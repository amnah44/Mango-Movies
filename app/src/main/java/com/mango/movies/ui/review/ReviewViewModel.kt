package com.mango.movies.ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class ReviewViewModel: ViewModel(), ReviewInteractionListener {
    val review = ReviewRepository.movieReview().asLiveData()
}