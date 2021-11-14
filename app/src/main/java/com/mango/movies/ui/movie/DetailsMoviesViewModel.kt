package com.mango.movies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.util.Event
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsMoviesViewModel: ViewModel() , MovieInteractionListener {
    private var _similarMovies = MutableLiveData<State<BaseResponse<Movie>?>?>()
    val similarMovies: LiveData<State<BaseResponse<Movie>?>?>
        get() = _similarMovies
    private val _selectedMovieEvent = MutableLiveData<Event<Movie>>()
    val selectedMovieEvent: LiveData<Event<Movie>>
        get() = _selectedMovieEvent

    fun getSimilarMovie(movieId: Int) {
       viewModelScope.launch {
            Repository.getSimilarMovie(movieId).collect {
                _similarMovies.postValue(it)
            }
        }
    }

    override fun onClickMovie(movie: Movie) {
        _selectedMovieEvent.postValue(Event(movie))
    }
}