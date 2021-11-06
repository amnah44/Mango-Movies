package com.mango.movies.ui.home

import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onClickMovie(movieNowPlayingResult: MovieNowPlayingResult)
    fun onTopRateClick(movieTopRate: MovieTopRatedResult)
}

