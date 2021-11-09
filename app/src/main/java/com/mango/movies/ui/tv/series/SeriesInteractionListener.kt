package com.mango.movies.ui.tv.series

import com.mango.movies.model.domain.Series
import com.mango.movies.ui.base.BaseInteractionListener

interface SeriesInteractionListener : BaseInteractionListener {
    fun onSeriesClick(series: Series)
}
