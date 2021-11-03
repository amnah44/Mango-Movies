package com.mango.movies.ui.person.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.person.PersonInteractionListener
import com.mango.movies.ui.person.PersonPopularViewModel

class PersonDetailsViewModel(repository: MovieRepository): ViewModel(){
    val details = repository.personDetails(40).asLiveData()
}