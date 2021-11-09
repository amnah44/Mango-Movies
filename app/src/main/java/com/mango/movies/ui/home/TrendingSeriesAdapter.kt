package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.Series
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.tv.series.SeriesInteractionListener

class TrendingSeriesAdapter(
    item: List<Series>,
    listener: SeriesInteractionListener
) : BaseAdapter<Series>(item, listener) {
    override val layoutId: Int = R.layout.item_trending_series
}
