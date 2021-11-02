package com.mango.movies.ui.home

import com.mango.movies.R
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener

class HomeAdapter(
    item: List<Genre>,
    listener: HomeInteractionListener
) : BaseAdapter<Genre>(item, listener) {
    override val layoutId: Int = R.layout.item_genre
}

interface HomeInteractionListener : BaseInteractionListener {
    fun onClickCategory(genre: Genre)
}