package com.mango.movies.ui.person


import com.mango.movies.model.domain.PersonPopularResult
import com.mango.movies.ui.base.BaseInteractionListener

interface PersonInteractionListener : BaseInteractionListener {
    fun onClickPerson(person: PersonPopularResult)
}