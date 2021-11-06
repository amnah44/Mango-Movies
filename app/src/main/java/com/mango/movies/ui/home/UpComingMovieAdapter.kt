package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.model.domain.movie.popular.MoviePopularResult
import com.mango.movies.model.domain.movie.upComing.MovieUpComingResult
import com.mango.movies.ui.base.BaseAdapter

class UpComingMovieAdapter(
    item: List<MovieUpComingResult>,
    listener: HomeInteractionListener
) : BaseAdapter<MovieUpComingResult>(item, listener) {
    override val layoutId: Int = R.layout.item_now_playing_movie
    override fun getItemCount(): Int = 8
}
