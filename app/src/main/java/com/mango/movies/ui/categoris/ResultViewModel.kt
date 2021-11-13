package com.mango.movies.ui.categoris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.Movie
import com.mango.movies.model.domain.Series
import com.mango.movies.model.domain.category.MovieAndTvByGenreResponse
import com.mango.movies.model.domain.genre.GenerResponse
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.mango.movies.model.domain.category.Result
import com.mango.movies.model.domain.details.DetailsResponse
import com.mango.movies.util.Event

class ResultViewModel() : ViewModel(){

}