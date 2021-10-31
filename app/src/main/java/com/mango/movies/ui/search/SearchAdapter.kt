package com.mango.movies.ui.search
import com.mango.movies.R
import com.mango.movies.model.domain.searchResponse.Result
import com.mango.movies.ui.base.BaseAdapter

class SearchAdapter(
    items: List<Result>,
    listener: SearchInteractionListener
) : BaseAdapter<Result>(items, listener) {
    override val layoutId: Int = R.layout.item_search
}
