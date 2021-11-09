package com.mango.movies.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.movie.MovieInteractionListener
import com.mango.movies.ui.series.SeriesInteractionListener
import com.mango.movies.util.Event

class HomeViewModel : ViewModel(), SeriesInteractionListener, MovieInteractionListener {
    val upComingMovie = MovieRepository.upcomingMovies().asLiveData()
    val topRateMovies = MovieRepository.ratedMovies().asLiveData()
    val trendingTV = MovieRepository.tvTrending().asLiveData()
    val topRateSeries = MovieRepository.topRatedTvShow().asLiveData()
    val movieEvent = MutableLiveData<Event<Movie>>()
    val seriesEvent = MutableLiveData<Event<Series>>()

    override fun onSeriesClick(series: Series) {
        seriesEvent.postValue(
            Event(series)
        )
    }
    override fun onClickMovie(movie: Movie) {
        movieEvent.postValue(
            Event(movie)
        )
    }
}