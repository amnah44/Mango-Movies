package com.mango.movies.ui.person.details


import com.mango.movies.R
import com.mango.movies.model.domain.person.popular.KnownFor
import com.mango.movies.ui.base.BaseAdapter

class KnownForAdapter(items: List<KnownFor>) :
    BaseAdapter<KnownFor>(items,null) {
    override val layoutId: Int = R.layout.item_known_for
}
