package com.mango.movies.ui.search


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.searchResponse.Result
import com.mango.movies.model.domain.searchResponse.SearchResponse
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class SearchViewModel : ViewModel(), SearchInteractionListener {
    var searchResult = MutableLiveData<State<SearchResponse?>?>()
    var selectedMovie =  MutableLiveData<Result?>()
    var flag=MutableLiveData<Boolean>()

    init {
        flag.postValue(true)
    }

    override fun onClickMovie(movie: Result) {
        Log.v("ALI",movie.title.toString())
        selectedMovie.postValue(movie)
    }

    fun onTextChanged(text: CharSequence?) {
        flag.postValue(false)
        // TODO do something with text
        viewModelScope.launch {
            MovieRepository.searchMovie(text.toString()).collect {
                searchResult.postValue(it)
            }
        }
    }

}