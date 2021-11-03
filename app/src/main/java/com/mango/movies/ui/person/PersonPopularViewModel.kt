package com.mango.movies.ui.person


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavArgs

import kotlinx.coroutines.flow.collect
import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.launch

class PersonPopularViewModel(val repository: MovieRepository) : ViewModel(),PersonInteractionListener {
    val person = repository.personPopular().asLiveData()
    val personDetails = MutableLiveData<PersonPopularResult?>()
    val personArgs = MutableLiveData<State<PersonDetailsResponse?>?>()

    override fun onClickPerson(person: PersonPopularResult) {
        personDetails.postValue(person)
//        viewModelScope.launch {
//            person.id?.let { repository.personDetails(it) }?.collect {
//                personArgs.postValue(it)
//            }
//        }
    }
}