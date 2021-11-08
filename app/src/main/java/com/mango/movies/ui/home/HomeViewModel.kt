package com.mango.movies.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.mango.movies.model.domain.movie.details.MovieDetailsResponse
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.model.domain.movie.upComing.MovieUpComingResult
import com.mango.movies.model.domain.tv.topRated.TVTopRatedResult
import com.mango.movies.model.domain.tv.trending.TVTrendingResult
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(), HomeInteractionListener {
    val action: NavDirections get() = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
    val upComingMovie = MovieRepository.upcomingMovies().asLiveData()
    val topRateMovies = MovieRepository.ratedMovies().asLiveData()
    val trendingTV = MovieRepository.tvTrending().asLiveData()
    val topRateSeries = MovieRepository.topRatedTvShow().asLiveData()

    val movieDetails = MutableLiveData<State<MovieDetailsResponse?>?>()
    private fun getMovieDetails(movie: MovieDetailsResponse){
        viewModelScope.launch {
            movie.id?.let { MovieRepository.movieDetails(it) }?.collect {
                movieDetails.postValue(it)
            }
        }
    }

    override fun onTopRateMoviesClick(movieTopRate: MovieTopRatedResult) {

    }

    override fun onTopRateSeriesClick(seriesTopRate: TVTopRatedResult) {

    }

    override fun onTrendingClick(tvTrending: TVTrendingResult) {

    }

    override fun onUpComingMoviesClick(moviesUpComing: MovieUpComingResult) {

    }

}