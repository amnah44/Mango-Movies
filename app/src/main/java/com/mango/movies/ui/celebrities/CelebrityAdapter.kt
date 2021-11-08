package com.mango.movies.ui.celebrities

import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.R
import com.mango.movies.model.domain.CelebrityPopularResult

class CelebrityAdapter(items: List<CelebrityPopularResult>, listener: CelebrityInteractionListener?) :
    BaseAdapter<CelebrityPopularResult>(items, listener) {
    override val layoutId = R.layout.item_celebrity
}