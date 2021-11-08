package com.mango.movies.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.navigation.NavDirections
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.repositiory.MovieRepository

class HomeViewModel : ViewModel(), HomeInteractionListener {
    val action: NavDirections get() = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
    val upComingMovie = MovieRepository.upcomingMovies().asLiveData()
    val topRateMovies = MovieRepository.ratedMovies().asLiveData()
    val trendingTV = MovieRepository.tvTrending().asLiveData()
    val topRateSeries = MovieRepository.topRatedTvShow().asLiveData()

    val movieDetails = MutableLiveData<Movie>()
    private fun getMovieDetails(movie: Movie){
        movieDetails.postValue(movie)
    }

    override fun onTopRateMoviesClick(movieTopRate: Movie) {
        getMovieDetails(movieTopRate)
    }

    override fun onTopRateSeriesClick(seriesTopRate: Movie) {
        TODO("Not yet implemented")
    }

    override fun onTrendingClick(tvTrending: Movie) {
        TODO("Not yet implemented")
    }

    override fun onUpComingMoviesClick(moviesUpComing: Movie) {
        movieDetails.postValue(moviesUpComing)
    }
}