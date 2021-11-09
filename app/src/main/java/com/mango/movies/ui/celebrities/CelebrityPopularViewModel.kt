package com.mango.movies.ui.celebrities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.CelebrityPopularResult
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.celebrities.details.KnownForInteractionListener

class CelebrityPopularViewModel : ViewModel(),
    CelebrityInteractionListener, KnownForInteractionListener {
    val persons = MovieRepository.personPopular().asLiveData()
    val personDetails = MutableLiveData<CelebrityPopularResult?>()

    val movieDetails = MutableLiveData<Movie>()
    val seriesDetails = MutableLiveData<Series>()

    override fun onClickCelebrity(celebrity: CelebrityPopularResult) {
        personDetails.postValue(celebrity)
    }

    private fun getMovieDetails(movie: Movie){
        movieDetails.postValue(movie)
    }
    private fun getSeriesDetails(series: Series){
        seriesDetails.postValue(series)
    }
    override fun getKnownFor(movieDetails: Movie, seriesDetails: Series) {
        getMovieDetails(movieDetails)
        getSeriesDetails(seriesDetails)
    }
}