package com.mango.movies.ui.celebrities


import com.mango.movies.model.domain.celebrity.popular.PersonPopularResult
import com.mango.movies.ui.base.BaseInteractionListener

interface CelebrityInteractionListener : BaseInteractionListener {
    fun onClickCelebrity(person: PersonPopularResult)
}