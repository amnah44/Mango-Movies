package com.mango.movies.ui.people

import androidx.lifecycle.ViewModel
import com.mango.movies.model.repositiory.MovieRepository

class PeopleDetailsViewModel(repository: MovieRepository) : ViewModel(){
    val details = repository.personPopular()
}