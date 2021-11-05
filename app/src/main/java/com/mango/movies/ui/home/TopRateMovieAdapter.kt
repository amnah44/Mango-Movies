package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.ui.base.BaseAdapter


class TopRateMovieAdapter(
    item: List<MovieTopRatedResult>,
    listener: HomeInteractionListener
) : BaseAdapter<MovieTopRatedResult>(item, listener) {
    override val layoutId: Int = R.layout.item_top_rate_movie
}