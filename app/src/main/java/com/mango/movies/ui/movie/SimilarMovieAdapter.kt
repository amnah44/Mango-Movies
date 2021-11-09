package com.mango.movies.ui.movie

import com.mango.movies.R
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseAdapter

class SimilarMovieAdapter(
    items: List<Movie>, listener: MovieInteractionListener
) : BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_details
}
