package com.mango.movies.ui.categoris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.mango.movies.model.domain.category.Result
import com.mango.movies.util.Event

class ResultViewModel() : ViewModel(),ResultInteractionListener ,GenreInteractionListener{
    private val _genreMovieList = MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genreMovieList: LiveData<State<MovieAndTvByGenreResponse?>>
        get() = _genreMovieList
    private val _genres = MutableLiveData<State<GenerResponse?>>()
    val genres: LiveData<State<GenerResponse?>>
        get() = _genres
    private val _selectedMovieEvent = MutableLiveData<Event<State<Movie?>>>()
    val selectedMovieEvent: LiveData<Event<State<Movie?>>>
        get() = _selectedMovieEvent
    private val _selectedSeriesEvent = MutableLiveData<Event<State<Series?>>>()
    val selectedSeriesEvent: LiveData<Event<State<Series?>>>
        get() = _selectedSeriesEvent
    var requiredGenre: Genre?=null
    var flag=true

    init {
        getGenre()
        getMovie()
    }
    private fun getMovie(){
        viewModelScope.launch {
            Repository.getGenreMovieOrTv(requiredGenre?.id,flag).collect {
                _genreMovieList.postValue(it)
            }
        }
    }

    private fun getGenre(){
        viewModelScope.launch {
            Repository.genres(flag).collect {
                _genres.postValue(it)
            }
        }
    }

    fun changeMovieOrSeries(switchFlag:Boolean){
        flag=switchFlag
        requiredGenre = if (flag)
            Genre(28,"action")
        else
            Genre(10759,"action")
        getGenre()
        getMovie()
    }

    override fun onClickItem(result: Result) {
        if(flag){
           viewModelScope.launch {
               Repository.movieDetails(result.id).collect {
                   _selectedMovieEvent.postValue(Event(it))
               }
           }
        }

        else{
            viewModelScope.launch {
                Repository.tvShowDetails(result.id).collect {
                    _selectedSeriesEvent.postValue(Event(it))
                }
            }
        }

    }

    override fun onClickCategory(genre: Genre) {
        requiredGenre=genre
        getMovie()
    }

}