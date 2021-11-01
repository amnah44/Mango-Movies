package com.mango.movies.ui.person

import android.widget.BaseAdapter
import com.mango.movies.model.domain.person.popular.PersonPopularResponse
import com.mango.movies.model.domain.person.popular.PersonPopularResult

class PersonAdapter(items: List<PersonPopularResult>,listener: PersonInteractionListener)
    : BaseAdapter<PersonPopularResult>(items,listener){

}