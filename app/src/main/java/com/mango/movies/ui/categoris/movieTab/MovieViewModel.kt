package com.mango.movies.ui.categoris.movieTab

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.category.Result
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.categoris.GenreInteractionListener
import com.mango.movies.ui.categoris.ResultInteractionListener
import com.mango.movies.util.Event
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel(), GenreInteractionListener, ResultInteractionListener {
    val selectedMovieEvent = MutableLiveData<Event<State<Movie?>>>()
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genres =MovieRepository.genres(true).asLiveData()
    var requiredGenre=Genre(28,"action")

    init {
        getMovie()
    }

    fun getMovie(){
        viewModelScope.launch {
            MovieRepository.getGenreMovieOrTv(requiredGenre?.id, true).collect {
                genreMovieList.postValue(it)
            }
        }
    }

    override fun onClickCategory(genre: Genre) {
        requiredGenre=genre
        getMovie()
    }

    override fun onClickItem(result: Result) {
                viewModelScope.launch {
                    result.id?.let {
                        MovieRepository.movieDetails(it).collect {
                            selectedMovieEvent.postValue(Event(it))
                        }
                    }
                }


    }


}