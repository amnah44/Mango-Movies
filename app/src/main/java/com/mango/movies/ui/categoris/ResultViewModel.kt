package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ResultViewModel() : ViewModel(),ResultInteractionListener ,GenreInteractionListener{
    var requiredGenre: Genre?=null
    var flag=true
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genres =MutableLiveData<State<GenerResponse?>>()

    val genreId=MutableLiveData<Genre>()

    init {
        requiredGenre=Genre(28,"action")
        getGenre()
        getMovie()
    }
    fun getMovie(){
        viewModelScope.launch {
            MovieRepository.getGenreMovieOrTv(requiredGenre?.id,flag).collect {
                genreMovieList.postValue(it)
            }
        }
    }

    fun getGenre(){
        viewModelScope.launch {
            MovieRepository.genres(flag).collect {
                genres.postValue(it)
            }
        }
    }





    fun changeMovieOrSeries(){
        flag=flag?.not()
        getGenre()
        getMovie()
    }

    override fun onClickItem() {
        TODO("Not yet implemented")
    }

    override fun onClickCategory(genre: Genre) {
        requiredGenre=genre
        getMovie()
    }

}