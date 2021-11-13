package com.mango.movies.ui.celebrities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.CelebrityPopularResult
import com.mango.movies.model.domain.details.DetailsResponse
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.ui.celebrities.details.KnownForInteractionListener
import com.mango.movies.util.Event

class CelebrityPopularViewModel : ViewModel(),
    CelebrityInteractionListener, KnownForInteractionListener {
    val persons = Repository.personPopular().asLiveData()
    val personEvent = MutableLiveData<Event<CelebrityPopularResult>>()

    override fun onClickCelebrity(celebrity: CelebrityPopularResult) {
        personEvent.postValue(
            Event(celebrity)
        )
    }

    override fun getKnownFor(movieDetails: DetailsResponse?, tvDetails: DetailsResponse?) {

    }
}