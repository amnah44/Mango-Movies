package com.mango.movies.ui.search
import com.mango.movies.model.domain.searchResponse.Result
import com.mango.movies.ui.base.BaseInteractionListener

interface SearchInteractionListener  : BaseInteractionListener {
    fun onClickMovie(match: Result)
}