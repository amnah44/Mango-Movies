package com.mango.movies.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.CinemaConfiguration
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.movie.MovieInteractionListener
import com.mango.movies.ui.series.SeriesInteractionListener
import com.mango.movies.util.Event
import java.util.*

class HomeViewModel : ViewModel(), SeriesInteractionListener, MovieInteractionListener {
    val upComingMovie = MovieRepository.upcomingMovies().asLiveData()
    val topRateMovies = MovieRepository.ratedMovies().asLiveData()
    val trendingTV = MovieRepository.tvTrending().asLiveData()
    val topRateSeries = MovieRepository.topRatedTvShow().asLiveData()
    val movieEvent = MutableLiveData<Event<Movie>>()

    val movieDetails = MutableLiveData<Movie>()
    val seriesDetails = MutableLiveData<Series>()
    private fun getMovieDetails(movie: Movie){
        movieDetails.postValue(movie)
    }

    override fun onSeriesClick(series: Series) {
        seriesDetails.postValue(series)

    }

    override fun onClickMovie(movie: Movie) {
        movieEvent.postValue(
            Event(movie)
        )

    }

}