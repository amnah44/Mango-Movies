package com.mango.movies.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.ui.movie.MovieInteractionListener
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(), MovieInteractionListener {
    private var _searchResult = MutableLiveData<State<BaseResponse<Movie>?>?>()
    val searchResult: LiveData<State<BaseResponse<Movie>?>?>
        get() = _searchResult
    private var _selectedMovie = MutableLiveData<Movie?>()
    val selectedMovie: LiveData<Movie?>
        get() = _selectedMovie
    private var _flag = MutableLiveData<Boolean>()
    val flag: LiveData<Boolean>
        get() = _flag

    init {
        _flag.postValue(true)
    }

    override fun onClickMovie(movie: Movie) {
        _selectedMovie.postValue(movie)
    }

    fun onTextChanged(text: CharSequence?) {
        _flag.postValue(false)

        if (text.isNullOrEmpty()) {
            _flag.postValue(true)
            _searchResult.postValue(null)
        } else {
            viewModelScope.launch {
                Repository.searchMovie(text.toString()).debounce(1000).collect {
                    _searchResult.postValue(it)
                }
            }
        }
    }

}