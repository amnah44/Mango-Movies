package com.mango.movies.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.ui.movie.MovieInteractionListener
import com.mango.movies.ui.series.SeriesInteractionListener
import com.mango.movies.util.Event

class HomeViewModel : ViewModel(), SeriesInteractionListener, MovieInteractionListener {
    val upComingMovie = Repository.upcomingMovies().asLiveData()
    val topRateMovies = Repository.ratedMovies().asLiveData()
    val trendingTV = Repository.tvTrending().asLiveData()
    val topRateSeries = Repository.topRatedTvShow().asLiveData()
    private val _movieEvent = MutableLiveData<Event<Movie>>()
    val movieEvent: LiveData<Event<Movie>>
        get() = _movieEvent
    private val _seriesEvent = MutableLiveData<Event<Series>>()
    val seriesEvent: LiveData<Event<Series>>
        get() = _seriesEvent


    override fun onSeriesClick(series: Series) {
        _seriesEvent.postValue(
            Event(series)
        )
    }
    override fun onClickMovie(movie: Movie) {
        _movieEvent.postValue(
            Event(movie)
        )
    }
}