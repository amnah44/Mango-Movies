package com.mango.movies.ui.search
import com.mango.movies.R
import com.mango.movies.model.domain.Movie
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.movie.MovieInteractionListener

class SearchAdapter(items: List<Movie>, listener: MovieInteractionListener) : BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_search
}
