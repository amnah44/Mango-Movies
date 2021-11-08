package com.mango.movies.ui.home

import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.model.domain.movie.upComing.MovieUpComingResult
import com.mango.movies.model.domain.tv.topRated.TVTopRatedResult
import com.mango.movies.model.domain.tv.trending.TVTrendingResult
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onTopRateMoviesClick(movieTopRate: MovieTopRatedResult)
    fun onTopRateSeriesClick(seriesTopRate: TVTopRatedResult)
    fun onTrendingClick(tvTrending: TVTrendingResult)
    fun onUpComingMoviesClick(moviesUpComing: MovieUpComingResult)
}

