package com.mango.movies.ui.celebrities.details


import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.ui.base.BaseInteractionListener

interface KnownForInteractionListener : BaseInteractionListener {
    fun getKnownFor(movieDetails: Movie, seriesDetails: Series)
}