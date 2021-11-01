package com.mango.movies.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.searchResponse.Result
import com.mango.movies.model.repositiory.MovieRepository

class SearchViewModel : ViewModel(),SearchInteractionListener {

    var searchResult = MovieRepository.searchMovie("man").asLiveData()

    override fun onClickMovie(match: Result) {

    }
}