package com.mango.movies.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() , MovieInteractionListener {
    var similarMovies = MutableLiveData<State<BaseResponse<Movie>?>?>()
    var selectedMovie =  MutableLiveData<Movie?>()

    fun getSimilarMovie(movieId: Int) {
       viewModelScope.launch {
            MovieRepository.getSimilarMovie(movieId).collect {
                similarMovies.postValue(it)
            }
        }
    }

    override fun onClickMovie(movie: Movie) {
        selectedMovie.postValue(movie)
    }
}