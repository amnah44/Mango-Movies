package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.util.Event
import com.mango.movies.util.State

class SeriesViewModel:ViewModel() {
    val selectedSeriesEvent = MutableLiveData<Event<State<Series?>>>()
    val  genreMovieList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    var requiredGenre: Genre?=null
}