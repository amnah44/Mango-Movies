package com.mango.movies.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.navigation.NavDirections
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.movie.MovieInteractionListener
import com.mango.movies.ui.tv.series.SeriesInteractionListener

class HomeViewModel : ViewModel(), SeriesInteractionListener, MovieInteractionListener {
    val action: NavDirections get() = HomeFragmentDirections.actionHomeFragmentToSearchFragment()

    val upComingMovie = MovieRepository.upcomingMovies().asLiveData()
    val topRateMovies = MovieRepository.ratedMovies().asLiveData()
    val trendingTV = MovieRepository.tvTrending().asLiveData()
    val topRateSeries = MovieRepository.topRatedTvShow().asLiveData()

    val movieDetails = MutableLiveData<Movie>()
    val seriesDetails = MutableLiveData<Series>()
    private fun getMovieDetails(movie: Movie){
        movieDetails.postValue(movie)
    }

    override fun onSeriesClick(series: Series) {
        seriesDetails.postValue(series)
    }

    override fun onClickMovie(movie: Movie) {
        getMovieDetails(movie)
    }

}