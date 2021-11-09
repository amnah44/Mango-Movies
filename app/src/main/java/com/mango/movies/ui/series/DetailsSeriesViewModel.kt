package com.mango.movies.ui.series

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.Event
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsSeriesViewModel: ViewModel(), SeriesInteractionListener {
    var similarSeries = MutableLiveData<State<BaseResponse<Series>?>?>()
    var selectedSeriesEvent =  MutableLiveData<Event<Series>>()

    fun getSimilarSeries(seriesId: Int) {
        viewModelScope.launch {
            MovieRepository.getSimilarSeries(seriesId).collect {
                similarSeries.postValue(it)
            }
        }
    }

    override fun onSeriesClick(series: Series) {
        selectedSeriesEvent.postValue(Event(series))
    }
}