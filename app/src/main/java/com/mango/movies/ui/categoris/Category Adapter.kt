package com.mango.movies.ui.categoris

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mango.movies.BR
import com.mango.movies.R
import com.mango.movies.databinding.ItemGenreBinding
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
    var item: List<Genre>,
    val listener: GenreInteractionListener
):RecyclerView.Adapter<GenreAdapter.GenreViewHolder>(){
    private var selectedItem: Int=0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_genre,parent, false)
            )
    }

    override fun onBindViewHolder(holder: GenreViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val currentGenre = item[position]
        holder.binding.item=currentGenre
        holder.binding.listener=listener
        holder.binding.cardGenre.tag=item[position]
        holder.binding.cardGenre.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.dark_color))
        if (selectedItem == position) {
            holder.binding.cardGenre.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.orange))
        }

        holder.binding.cardGenre.setOnClickListener {
            listener.onClickCategory(currentGenre)
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }
    }

    override fun getItemCount()=item.size

    class GenreViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        val binding= ItemGenreBinding.bind(viewItem)
    }

    fun setItems(newItems : List<Genre>){
        item = newItems
        notifyDataSetChanged()
    }
}

interface GenreInteractionListener : BaseInteractionListener {
    fun onClickCategory(genre: Genre)
}