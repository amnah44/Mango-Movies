package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    //    fun onClickCategory(genre: Genre)
    fun onClickMovie(movieNowPlayingResult: MovieNowPlayingResult)
    fun onTopRateClick(movieTopRate: MovieTopRatedResult)
}

