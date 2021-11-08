package com.mango.movies.ui.person

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.details.DetailsResponse
import com.mango.movies.model.domain.PersonPopularResult
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.person.details.KnownForInteractionListener

class PersonPopularViewModel : ViewModel(),
    PersonInteractionListener, KnownForInteractionListener {
    val persons = MovieRepository.personPopular().asLiveData()
    val personDetails = MutableLiveData<PersonPopularResult?>()

    override fun onClickPerson(person: PersonPopularResult) {
        personDetails.postValue(person)
    }

    override fun getKnownFor(movieDetails: DetailsResponse?, tvDetails: DetailsResponse?) {
        TODO("Not yet implemented")
    }
}