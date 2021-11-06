package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.util.State

class CategoryViewModel() : ViewModel() {
    var requiredGenre: Genre?=null
    var flag=true
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()

    init {
        requiredGenre=Genre(28,"action")
    }


}