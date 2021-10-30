package com.mango.movies.ui.person

import androidx.lifecycle.ViewModel
import com.mango.movies.model.repositiory.MovieRepository

class PersonDetailsViewModel(repository: MovieRepository) : ViewModel() {
    val details = repository.personDetails(124)
}