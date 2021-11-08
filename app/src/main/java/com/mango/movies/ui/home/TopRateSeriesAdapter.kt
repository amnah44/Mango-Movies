package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.Series
import com.mango.movies.ui.base.BaseAdapter

class TopRateSeriesAdapter(
    item: List<Series>,
    listener: HomeInteractionListener
) : BaseAdapter<Series>(item, listener) {
    override val layoutId: Int = R.layout.item_top_rate_series
}