package com.mango.movies.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.navigation.NavDirections
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.model.domain.movie.upComing.MovieUpComingResult
import com.mango.movies.model.domain.tv.topRated.TVTopRatedResult
import com.mango.movies.model.domain.tv.trending.TVTrendingResult
import com.mango.movies.model.repositiory.MovieRepository

class HomeViewModel : ViewModel(), HomeInteractionListener {
    val action: NavDirections get() = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
    val upComingMovie = MovieRepository.upcomingMovies().asLiveData()
    val topRateMovies = MovieRepository.ratedMovies().asLiveData()
    val trendingTV = MovieRepository.tvTrending().asLiveData()
    val topRateSeries = MovieRepository.topRatedTvShow().asLiveData()

    override fun onTopRateMoviesClick(movieTopRate: MovieTopRatedResult) {
        TODO("Not yet implemented")
    }

    override fun onTopRateSeriesClick(seriesTopRate: TVTopRatedResult) {
        TODO("Not yet implemented")
    }

    override fun onTrendingClick(tvTrending: TVTrendingResult) {
        TODO("Not yet implemented")
    }

    override fun onUpComingMoviesClick(moviesUpComing: MovieUpComingResult) {
        TODO("Not yet implemented")
    }

}