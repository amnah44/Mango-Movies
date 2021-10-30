package com.mango.movies.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.repositiory.MovieRepository

class DetailsViewModel(repository: MovieRepository) : ViewModel() {
    val movieDetails = repository.movieDetails(123).asLiveData()
    val tvDetails = repository.tvShowDetails(123).asLiveData()
}