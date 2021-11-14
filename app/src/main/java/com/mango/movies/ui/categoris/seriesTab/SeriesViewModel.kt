package com.mango.movies.ui.categoris.seriesTab

import androidx.lifecycle.*
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.category.MovieAndTvDetails
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.categoris.GenreInteractionListener
import com.mango.movies.ui.categoris.ResultInteractionListener
import com.mango.movies.util.Event
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SeriesViewModel:ViewModel() , GenreInteractionListener, ResultInteractionListener {
    private val _selectedSeriesEvent = MutableLiveData<Event<State<Series?>>>()
    val selectedSeriesEvent: LiveData<Event<State<Series?>>>
        get()=_selectedSeriesEvent
    private val  _genreSeriesList= MutableLiveData<State<MovieAndTvByGenreResponse?>>()
    val genreSeriesList:LiveData<State<MovieAndTvByGenreResponse?>>
        get()=_genreSeriesList
    private val _genres = MovieRepository.genres(false).asLiveData()
    val genres:LiveData<State<GenerResponse?>>
        get()=_genres
    private var _requiredGenre=Genre(10759,"action")

    init {

        getSeries()
    }
    fun getSeries(){
        viewModelScope.launch {
            MovieRepository.getGenreMovieOrTv(_requiredGenre?.id, false).collect {
                _genreSeriesList.postValue(it)
            }
        }
    }

    override fun onClickCategory(genre: Genre) {
        _requiredGenre=genre
        getSeries()
    }

    override fun onClickItem(movieAndTvDetails: MovieAndTvDetails) {
            viewModelScope.launch {
                movieAndTvDetails.id?.let {
                    MovieRepository.tvShowDetails(it).collect {
                        _selectedSeriesEvent.postValue(Event(it))
                    }
                }
            }

    }

}