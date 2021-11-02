package com.mango.movies.ui.search


import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.databinding.adapters.SearchViewBindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mango.movies.model.domain.searchResponse.Result
import com.mango.movies.model.domain.searchResponse.SearchResponse
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.util.State
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class SearchViewModel : ViewModel(), SearchInteractionListener {
    var searchResult = MutableLiveData<State<SearchResponse?>?>()
    override fun onClickMovie(match: Result) {

    }

    val onQueryTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.v("Test", "query = $query")
                viewModelScope.launch {
                    MovieRepository.searchMovie(query).collect {
                        searchResult.postValue(it)
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        }

}