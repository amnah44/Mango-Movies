package com.mango.movies.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mango.movies.R
import com.mango.movies.ui.base.BaseAdapter
import java.time.LocalDate


@BindingAdapter(value = ["app:showOnLoading"])
fun <T> showOnLoading(view: View, state: State<T>?) {
    if (state is State.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showOnError"])
fun <T> showOnError(view: View, state: State<T>?) {
    if (state is State.Error)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showOnSuccess"])
fun <T> showOnSuccess(view: View, state: State<T>?) {
    if (state is State.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}

@BindingAdapter(value = ["setFormattedDate"])
fun getYearFromDateString(view: TextView, dateStr: String? = "2021-11-01") {
    val date = LocalDate.parse(dateStr)
    view.text = date.year.toString()
}

@BindingAdapter("query")
fun setQuery(searchView: SearchView, queryText: String?) {
    searchView.setQuery(queryText, false)
}


@BindingAdapter("queryTextListener")
fun setOnQueryTextListener(
    searchView: SearchView,
    listener: SearchView.OnQueryTextListener?
) {
    searchView.setOnQueryTextListener(listener)
}

@BindingAdapter(value = ["imageUrl"])
fun setImageFromUrl(view: ImageView,url: String?){
    Glide.with(view).load(url).into(view)
}

@BindingAdapter(value = ["movieImageUrl"])
fun setMovieImageFromUrl(view: ImageView,url: String?){
    Glide.with(view)
        .load(Constant.BASE_MOVIE_URL + url)
        .placeholder(R.drawable.ic_place_holder)
        .error(R.drawable.ic_error)
        .into(view)
}