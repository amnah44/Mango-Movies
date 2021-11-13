package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.Event
import com.mango.movies.util.State

class MovieViewModel:ViewModel() {
    val selectedMovieEvent = MutableLiveData<Event<State<Movie?>>>()
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genres =MovieRepository.genres(true).asLiveData()
    var requiredGenre=Genre(28,"action")

    
}