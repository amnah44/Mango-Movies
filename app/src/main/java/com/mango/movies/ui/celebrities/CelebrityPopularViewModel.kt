package com.mango.movies.ui.celebrities


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mango.movies.model.domain.movie.details.MovieDetailsResponse
import com.mango.movies.model.domain.celebrity.popular.CelebrityPopularResult
import com.mango.movies.model.domain.tv.details.TvDetailsResponse
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.celebrities.details.KnownForInteractionListener


class CelebrityPopularViewModel : ViewModel(),
    CelebrityInteractionListener, KnownForInteractionListener {
    val persons = MovieRepository.personPopular().asLiveData()
    val personDetails = MutableLiveData<CelebrityPopularResult?>()

    override fun onClickCelebrity(celebrity: CelebrityPopularResult) {
        personDetails.postValue(celebrity)
    }


    override fun getKnownFor(movieDetails: MovieDetailsResponse?, tvDetails: TvDetailsResponse?) {
        TODO("Not yet implemented")
    }
}