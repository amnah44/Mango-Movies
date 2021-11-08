package com.mango.movies.ui.person

import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.R
import com.mango.movies.model.domain.PersonPopularResult

class PersonAdapter(items: List<PersonPopularResult>, listener: PersonInteractionListener?) :
    BaseAdapter<PersonPopularResult>(items, listener) {
    override val layoutId = R.layout.item_people
}