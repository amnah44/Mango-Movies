package com.mango.movies.ui.person


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavArgs
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.model.domain.movie.details.MovieDetailsResponse
import kotlinx.coroutines.flow.collect
import com.mango.movies.model.domain.person.details.PersonDetailsResponse
import com.mango.movies.model.domain.person.popular.KnownFor
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResult
import com.mango.movies.model.domain.tv.details.TvDetailsResponse
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.home.HomeFragmentDirections
import com.mango.movies.ui.home.HomeInteractionListener
import com.mango.movies.ui.person.details.KnownForInteractionListener

import com.mango.movies.util.State
import com.mango.movies.util.navigate
import kotlinx.coroutines.launch


class PersonPopularViewModel : ViewModel(),
    PersonInteractionListener, KnownForInteractionListener {
    val persons = MovieRepository.personPopular().asLiveData()
    val personDetails = MutableLiveData<PersonPopularResult?>()
    override fun onClickPerson(person: PersonPopularResult) {
        Log.v("Ali", "onClickPerson")
        Log.v("Ali", person.toString())
        Log.v("Ali", person.name.toString())

//        viewModelScope.launch {
            personDetails.postValue(person)
//        }
//        val action = PersonFragmentDirections.actionPersonFragmentToPersonDetailsFragment(person)
//        Navigation.createNavigateOnClickListener(action)
    }


    override fun getKnownFor(movieDetails: MovieDetailsResponse?, tvDetails: TvDetailsResponse?) {
        TODO("Not yet implemented")
    }
}