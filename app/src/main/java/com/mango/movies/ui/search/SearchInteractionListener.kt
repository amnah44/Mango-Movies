package com.mango.movies.ui.search
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseInteractionListener

interface SearchInteractionListener  : BaseInteractionListener {
    fun onClickMovie(movie: Movie)
}