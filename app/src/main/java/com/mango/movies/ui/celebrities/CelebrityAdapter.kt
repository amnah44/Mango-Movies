package com.mango.movies.ui.celebrities

import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.R
import com.mango.movies.model.domain.person.popular.PersonPopularResult

class CelebrityAdapter(items: List<PersonPopularResult>, listener: CelebrityInteractionListener?) :
    BaseAdapter<PersonPopularResult>(items, listener) {
    override val layoutId = R.layout.item_people
}