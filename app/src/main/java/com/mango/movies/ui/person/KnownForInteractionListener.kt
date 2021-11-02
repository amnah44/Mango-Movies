package com.mango.movies.ui.person

import com.mango.movies.ui.base.BaseInteractionListener

interface KnownForInteractionListener : BaseInteractionListener {
    fun getMovieDetails()
    fun getTvDetails()
}