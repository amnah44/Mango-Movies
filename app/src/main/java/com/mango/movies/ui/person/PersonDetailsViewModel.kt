package com.mango.movies.ui.person

import androidx.lifecycle.ViewModel
import com.mango.movies.model.repositiory.MovieRepository

class PersonDetailsViewModel : ViewModel() {
    val details = MovieRepository.personDetails(124)
}