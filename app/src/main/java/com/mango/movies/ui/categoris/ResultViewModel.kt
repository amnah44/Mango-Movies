package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ResultViewModel() : ViewModel(),ResultInteractionListener {
    var requiredGenre: Genre?=null
    var flag=true
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    init {
        requiredGenre=Genre(28,"action")
        getMovie()
    }
    fun getMovie(){
        viewModelScope.launch {
            MovieRepository.getGenreMovieOrTv(requiredGenre?.id,flag).collect {
                genreMovieList.postValue(it)
            }
        }
    }

    fun changeMovieOrSeries(){
        flag=flag?.not()
        getMovie()
    }

    override fun onClickItem() {
        TODO("Not yet implemented")
    }

}