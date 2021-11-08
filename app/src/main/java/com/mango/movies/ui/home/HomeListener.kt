package com.mango.movies.ui.home

import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onTopRateMoviesClick(movieTopRate: Movie)
    fun onUpComingMoviesClick(moviesUpComing: Movie)

    fun onTopRateSeriesClick(seriesTopRate: Series)
    fun onTrendingClick(tvTrending: Series)
}

