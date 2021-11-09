package com.mango.movies.ui.tv.series

import com.mango.movies.R
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseAdapter

class SimilarSeriesAdapter(items: List<Movie>, listener: SeriesInteractionListener) : BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_series_details
}
