package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseAdapter

class UpComingMovieAdapter(
    item: List<Movie>,
    listener: HomeInteractionListener
) : BaseAdapter<Movie>(item, listener) {
    override val layoutId: Int = R.layout.item_up_coming_movie
}
