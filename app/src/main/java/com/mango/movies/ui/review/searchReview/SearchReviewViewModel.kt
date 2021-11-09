package com.mango.movies.ui.review.searchReview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mango.movies.model.domain.review.ReviewResponse
import com.mango.movies.util.State

class SearchReviewViewModel: ViewModel() {
    val searchReview = MutableLiveData<State<ReviewResponse?>?>()
}