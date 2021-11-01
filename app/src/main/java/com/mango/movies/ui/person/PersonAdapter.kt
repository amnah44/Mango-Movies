package com.mango.movies.ui.person

import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.R
import com.mango.movies.model.domain.person.popular.PersonPopularResult

class PersonAdapter(items: List<PersonPopularResult>, listener: PersonInteractionListener) :
    BaseAdapter<PersonPopularResult>(items, listener) {
    override val layoutId: Int get() = R.layout.fragment_people
}