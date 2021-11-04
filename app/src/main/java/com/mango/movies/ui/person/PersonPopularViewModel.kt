package com.mango.movies.ui.person


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavArgs
import com.mango.movies.model.domain.movie.details.MovieDetailsResponse

import kotlinx.coroutines.flow.collect
import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.KnownFor
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.domain.tv.details.TvDetailsResponse
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.person.details.KnownForInteractionListener
import com.mango.movies.util.State
import kotlinx.coroutines.launch

class PersonPopularViewModel(val repository: MovieRepository) : ViewModel(),PersonInteractionListener,KnownForInteractionListener{
    val person = repository.personPopular().asLiveData()
    val personDetails = MutableLiveData<PersonPopularResult?>()

    override fun onClickPerson(person: PersonPopularResult) {
        personDetails.postValue(person)
    }

    override fun getKnownFor(movieDetails: MovieDetailsResponse?, tvDetails: TvDetailsResponse?) {
        TODO("Not yet implemented")
    }

}