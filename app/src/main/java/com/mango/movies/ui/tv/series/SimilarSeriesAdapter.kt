package com.mango.movies.ui.tv.series

import com.mango.movies.R
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.movie.MovieInteractionListener



class SimilarSeriesAdapter(items: List<Movie>, listener: MovieInteractionListener) : BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_series_details
}
