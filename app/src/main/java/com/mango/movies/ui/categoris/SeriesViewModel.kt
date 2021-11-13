package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.Event
import com.mango.movies.util.State

class SeriesViewModel:ViewModel() {
    val selectedSeriesEvent = MutableLiveData<Event<State<Series?>>>()
    val  genreSeriesList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genres = MovieRepository.genres(false).asLiveData()
    var requiredGenre=Genre(10759,"action")

}