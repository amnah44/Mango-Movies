package com.mango.movies.ui.person.details


import com.mango.movies.model.domain.movie.details.MovieDetailsResponse
import com.mango.movies.model.domain.tv.details.TvDetailsResponse
import com.mango.movies.ui.base.BaseInteractionListener

interface KnownForInteractionListener : BaseInteractionListener {
    fun getKnownFor(movieDetails: MovieDetailsResponse?,tvDetails: TvDetailsResponse?)
}