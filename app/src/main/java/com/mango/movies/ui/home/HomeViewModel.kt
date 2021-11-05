package com.mango.movies.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.movie.nowPlaying.MovieNowPlayingResult
import com.mango.movies.model.domain.movie.topRated.MovieTopRatedResult
import com.mango.movies.model.repositiory.MovieRepository

class HomeViewModel() : ViewModel(), HomeInteractionListener {
//    private val repository = MovieRepository
//    val genres = MovieRepository.genres().asLiveData()
//    val genreId = MutableLiveData<Genre>()

    val nowPlayingMovies = MovieRepository.nowPlayingMovies().asLiveData()
    override fun onClickMovie(movieNowPlayingResult: MovieNowPlayingResult) {
        TODO("Not yet implemented")
    }


//    override fun onClickCategory(genre: Genre) {
////        genreId.postValue(genre)
//    }


}