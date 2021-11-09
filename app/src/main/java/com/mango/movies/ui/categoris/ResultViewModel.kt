package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.mango.movies.model.domain.category.Result
import com.mango.movies.model.domain.details.DetailsResponse
import com.mango.movies.util.Event

class ResultViewModel() : ViewModel(),ResultInteractionListener ,GenreInteractionListener{
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genres =MutableLiveData<State<GenerResponse?>>()
    val selectedMovieEvent = MutableLiveData<Event<State<Movie?>>>()
    val selectedSeriesEvent = MutableLiveData<Event<State<Series?>>>()
    var requiredGenre: Genre?=null
    var flag=true

    init {
        getGenre()
        getMovie()
    }
    private fun getMovie(){
        viewModelScope.launch {
            MovieRepository.getGenreMovieOrTv(requiredGenre?.id,flag).collect {
                genreMovieList.postValue(it)
            }
        }
    }

    private fun getGenre(){
        viewModelScope.launch {
            MovieRepository.genres(flag).collect {
                genres.postValue(it)
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
               MovieRepository.movieDetails(result.id).collect {
                   selectedMovieEvent.postValue(Event(it))
               }
           }
        }

        else{
            viewModelScope.launch {
                MovieRepository.tvShowDetails(result.id).collect {
                    selectedSeriesEvent.postValue(Event(it))
                }
            }
        }

    }

    override fun onClickCategory(genre: Genre) {
        requiredGenre=genre
        getMovie()
    }

}