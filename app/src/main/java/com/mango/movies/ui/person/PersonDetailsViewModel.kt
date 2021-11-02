package com.mango.movies.ui.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.repositiory.MovieRepository

class PersonDetailsViewModel(repository: MovieRepository): ViewModel(){
    val details = repository.personDetails(124567).asLiveData()
}