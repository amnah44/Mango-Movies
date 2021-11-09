package com.mango.movies.ui.movie

import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseInteractionListener

interface MovieInteractionListener  : BaseInteractionListener {
    fun onClickMovie(movie: Movie)
}