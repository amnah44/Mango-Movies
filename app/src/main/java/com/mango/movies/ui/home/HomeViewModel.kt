package com.mango.movies.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository

class HomeViewModel(repository: MovieRepository) : ViewModel(), HomeInteractionListener {
    val genres = repository.genres().asLiveData()

    override fun onClickCategory(genre: Genre) {

    }
}