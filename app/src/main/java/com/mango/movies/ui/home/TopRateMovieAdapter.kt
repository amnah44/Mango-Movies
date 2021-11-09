package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.movie.MovieInteractionListener

class TopRateMovieAdapter(
    item: List<Movie>,
    listener: MovieInteractionListener
) : BaseAdapter<Movie>(item, listener) {
    override val layoutId: Int = R.layout.item_top_rate_movie
}