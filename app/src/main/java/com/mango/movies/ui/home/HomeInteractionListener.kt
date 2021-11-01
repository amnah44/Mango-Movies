package com.mango.movies.ui.home

import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.ui.base.BaseInteractionListener

interface HomeInteractionListener: BaseInteractionListener {
    fun onClickCategory(genre: Genre)
}