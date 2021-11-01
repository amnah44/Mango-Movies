package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.ui.base.BaseAdapter

class HomeAdapter (
    item: List<Genre>,
    listener: HomeInteractionListener
): BaseAdapter<Genre>(item, listener) {
    override val layoutId: Int = R.layout.item_genre
}