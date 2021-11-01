package com.mango.movies.ui.person


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.repositiory.MovieRepository

class PersonPopularViewModel : ViewModel(),PersonInteractionListener {
    private val repository = MovieRepository
    val person = repository.personPopular().asLiveData()

    override fun onClickPerson(person: PersonPopularResult) {

    }
}