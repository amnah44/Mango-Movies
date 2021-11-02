package com.mango.movies.ui.person

import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.ui.base.BaseInteractionListener

interface PersonInteractionListener : BaseInteractionListener {
    fun onClickPerson(person: PersonPopularResult)
}