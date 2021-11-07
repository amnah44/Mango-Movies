package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.movie.upComing.MovieUpComingResult
import com.mango.movies.model.domain.tv.trending.TVTrendingResult
import com.mango.movies.ui.base.BaseAdapter

class TrendingSeriesAdapter(
    item: List<TVTrendingResult>,
    listener: HomeInteractionListener
) : BaseAdapter<TVTrendingResult>(item, listener) {
    override val layoutId: Int = R.layout.item_trending_series
}
