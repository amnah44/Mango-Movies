package com.mango.movies.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.model.repositiory.MovieRepository

class HomeViewModel(val repository: MovieRepository) : ViewModel(), HomeInteractionListener {
//    private val repository = MovieRepository
//    val genres = MovieRepository.genres().asLiveData()
//    val genreId = MutableLiveData<Genre>()

    val nowPlayingMovies = repository.popularMovies().asLiveData()

    override fun onClickMovie(movieNowPlayingResult: MovieNowPlayingResult) {

    }

//    override fun onClickCategory(genre: Genre) {
////        genreId.postValue(genre)
//    }


}