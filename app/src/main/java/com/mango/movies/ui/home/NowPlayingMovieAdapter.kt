package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.ui.base.BaseAdapter

class NowPlayingMovieAdapter(
    item: List<MovieNowPlayingResult>,
    listener: HomeInteractionListener
) : BaseAdapter<MovieNowPlayingResult>(item, listener) {
    override val layoutId: Int = R.layout.item_now_playing_movie
}
