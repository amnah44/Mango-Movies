package com.mango.movies.ui.celebrities

import com.mango.movies.model.domain.CelebrityPopularResult
import com.mango.movies.ui.base.BaseInteractionListener

interface CelebrityInteractionListener : BaseInteractionListener {
    fun onClickCelebrity(celebrity: CelebrityPopularResult)
}