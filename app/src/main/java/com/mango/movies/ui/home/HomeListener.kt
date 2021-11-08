package com.mango.movies.ui.home

import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onTopRateMoviesClick(movieTopRate: Movie)
    fun onTopRateSeriesClick(seriesTopRate: Movie)
    fun onTrendingClick(tvTrending: Movie)
    fun onUpComingMoviesClick(moviesUpComing: Movie)
}

