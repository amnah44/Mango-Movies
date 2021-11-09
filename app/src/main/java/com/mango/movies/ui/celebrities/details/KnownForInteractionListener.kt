package com.mango.movies.ui.celebrities.details

import com.mango.movies.model.domain.details.DetailsResponse
import com.mango.movies.ui.base.BaseInteractionListener

interface KnownForInteractionListener : BaseInteractionListener {
    fun getKnownFor(movieDetails: DetailsResponse
    ?,tvDetails: DetailsResponse?)
}