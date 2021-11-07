package com.mango.movies.ui.home

import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.model.domain.tv.trending.TVTrendingResult
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onTopRateClick(movieTopRate: MovieTopRatedResult)
    fun onTrendingClick(tvTrending: TVTrendingResult)
}

