package com.mango.movies.ui.review.searchReview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.review.ReviewResponse
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchReviewViewModel : ViewModel(), SearchReviewInteractionListener {
    private val _searchReview = MutableLiveData<State<ReviewResponse?>?>()
    val searchReview: LiveData<State<ReviewResponse?>?>
        get() =  _searchReview
    private val _flag = MutableLiveData<Boolean>()
    val flag: LiveData<Boolean>
        get() = _flag

    init {
        _flag.postValue(true)
    }

    fun onTextChanged(text: CharSequence?) {
        _flag.postValue(false)

        if (text.isNullOrEmpty()) {
            _flag.postValue(true)
            _searchReview.postValue(null)
        } else {
            _flag.postValue(false)
            viewModelScope.launch {
                Repository.searchMovieReview(text.toString()).collect {
                    _searchReview.postValue(it)
                }
            }
        }
    }
}