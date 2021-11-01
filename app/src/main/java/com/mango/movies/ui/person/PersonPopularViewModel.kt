package com.mango.movies.ui.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.repositiory.MovieRepository

class PersonPopularViewModel(repository: MovieRepository) : ViewModel() {
    val person = repository.personPopular().asLiveData()
}