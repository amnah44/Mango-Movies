package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.model.domain.tv.popular.TvPopularResponse
import com.mango.movies.model.domain.tv.topRated.TVTopRatedResult
import com.mango.movies.ui.base.BaseAdapter

class TopRateSeriesAdapter(
    item: List<TVTopRatedResult>,
    listener: HomeInteractionListener
) : BaseAdapter<TVTopRatedResult>(item, listener) {
    override val layoutId: Int = R.layout.item_top_rate_series
}