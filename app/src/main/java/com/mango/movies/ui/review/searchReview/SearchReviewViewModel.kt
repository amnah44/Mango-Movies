package com.mango.movies.ui.review.searchReview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.review.ReviewResponse
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchReviewViewModel : ViewModel(), SearchReviewInteractionListener {
    val searchReview = MutableLiveData<State<ReviewResponse?>?>()
    val flag = MutableLiveData<Boolean>()

    init {
        flag.postValue(true)
    }

    fun onTextChanged(text: CharSequence?) {
        flag.postValue(false)

        if (text.isNullOrEmpty()) {
            flag.postValue(true)
            searchReview.postValue(null)
        } else {
            flag.postValue(false)
            viewModelScope.launch {
                ReviewRepository.searchMovieReview(text.toString()).collect {
                    searchReview.postValue(it)
                }
            }
        }
    }
}