package com.mango.movies.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.BaseResponse
import com.mango.movies.model.domain.Series
import com.mango.movies.model.repositiory.Repository
import com.mango.movies.util.Event
import com.mango.movies.util.State
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailsSeriesViewModel: ViewModel(), SeriesInteractionListener {
    private var _similarSeries = MutableLiveData<State<BaseResponse<Series>?>?>()
    val similarSeries: LiveData<State<BaseResponse<Series>?>?>
        get() = _similarSeries
    private var _selectedSeriesEvent =  MutableLiveData<Event<Series>>()
    val selectedSeriesEvent: LiveData<Event<Series>>
        get() = _selectedSeriesEvent

    fun getSimilarSeries(seriesId: Int) {
        viewModelScope.launch {
            Repository.getSimilarSeries(seriesId).collect {
                _similarSeries.postValue(it)
            }
        }
    }

    override fun onSeriesClick(series: Series) {
        _selectedSeriesEvent.postValue(Event(series))
    }
}