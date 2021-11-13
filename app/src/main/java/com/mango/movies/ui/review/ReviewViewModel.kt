package com.mango.movies.ui.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.repositiory.Repository

class ReviewViewModel: ViewModel(), ReviewInteractionListener {
    val review = Repository.movieReview().asLiveData()
}