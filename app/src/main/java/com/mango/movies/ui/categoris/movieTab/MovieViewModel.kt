package com.mango.movies.ui.categoris.movieTab

import androidx.lifecycle.*
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.category.MovieAndTvDetails
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.categoris.GenreInteractionListener
import com.mango.movies.ui.categoris.ResultInteractionListener
import com.mango.movies.util.Event
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel(), GenreInteractionListener, ResultInteractionListener {
    private val _selectedMovieEvent = MutableLiveData<Event<State<Movie?>>>()
    val selectedMovieEvent: LiveData<Event<State<Movie?>>>
        get()=_selectedMovieEvent
    private val  _genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genreMovieList:LiveData<State<MovieAndTvByGenreResponse?>>
        get()=_genreMovieList
    private val _genres =MovieRepository.genres(true).asLiveData()
    val genres: LiveData<State<GenerResponse?>>
        get()=_genres
    private var _requiredGenre=Genre(28,"action")
    init {
        getMovie()
    }

    fun getMovie(){
        viewModelScope.launch {
            MovieRepository.getGenreMovieOrTv(_requiredGenre?.id, true).collect {
                _genreMovieList.postValue(it)
            }
        }
    }

    override fun onClickCategory(genre: Genre) {
        _requiredGenre=genre
        getMovie()
    }

    override fun onClickItem(movieAndTvDetails: MovieAndTvDetails) {
                viewModelScope.launch {
                    movieAndTvDetails.id?.let {
                        MovieRepository.movieDetails(it).collect {
                            _selectedMovieEvent.postValue(Event(it))
                        }
                    }
                }


    }


}