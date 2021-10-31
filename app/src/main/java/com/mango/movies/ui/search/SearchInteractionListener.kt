package com.mango.movies.ui.search
import com.mango.movies.ui.base.BaseInteractionListener
import com.mango.movies.model.domain.searchResponse.Result

interface SearchInteractionListener  : BaseInteractionListener {
    fun onClickMatch(match: Result)
}