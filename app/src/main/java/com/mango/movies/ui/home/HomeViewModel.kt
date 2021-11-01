package com.mango.movies.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.repositiory.MovieRepository

class HomeViewModel : ViewModel() {
    val genres = MovieRepository.genres().asLiveData()
}