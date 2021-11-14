package com.mango.movies.ui.categoris

import androidx.core.content.ContextCompat
import com.mango.movies.R
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener
import com.mango.movies.model.domain.category.MovieAndTvDetails
import com.mango.movies.model.domain.genre.Genre

class MovieAndTvResultAdapter(
    item:List<MovieAndTvDetails>,
    listener:ResultInteractionListener
):BaseAdapter<MovieAndTvDetails>(item,listener){
    override val layoutId: Int = R.layout.item_category

}

interface ResultInteractionListener: BaseInteractionListener {
    fun onClickItem(movieAndTvDetails: MovieAndTvDetails)
}

class GenreAdapter(
    item: List<Genre>,
    listener: GenreInteractionListener
) : BaseAdapter<Genre>(item, listener) {
    override val layoutId: Int = R.layout.item_genre
    var index=0
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            index=position
            notifyDataSetChanged()
        }
            if(holder is ItemViewHolder)
                if(index==position)
                    holder.binding.root.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.orange))
                else
                    holder.binding.root.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.dark_color))

    }
}

interface GenreInteractionListener : BaseInteractionListener {
    fun onClickCategory(genre: Genre)
}