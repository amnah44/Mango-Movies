package com.mango.movies.util

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mango.movies.R
import com.mango.movies.model.domain.genre.Genre
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.categoris.GenreAdapter

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

@BindingAdapter(value = ["app:items2"])
fun <T> setRecyclerItems2(view: RecyclerView, items: List<Genre>?) {
    if (items != null) {
        (view.adapter as GenreAdapter)?.setItems(items)
    } else {
        (view.adapter as GenreAdapter)?.setItems(emptyList())
    }
}

@BindingAdapter(value = ["imageUrl"])
fun ImageView.seImageFromUrl(url: String?) {
    Glide.with(this)
        .load(Constant.BASE_PERSON_IMAGE_URL + url)
        .placeholder(R.drawable.ic_film_fill)
        .error(R.drawable.ic_error)
        .into(this)
}

@BindingAdapter(value = ["reviewImageUrl"])
fun ImageView.setReviewImageFromUrl(url: String?) {
    url?.let { Log.v("image", "anu $it") }
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_film_fill)
        .error(R.drawable.ic_error)
        .into(this)
}

@BindingAdapter(value=["goOnTextChanged"])
fun goOnTextChanged(view: View, flag:Boolean){
    if (flag){
        view.visibility=View.VISIBLE
    }
    else{
        view.visibility=View.GONE
    }
}

@BindingAdapter(value=["isRecyclerEmpty"])
fun <T> isRecyclerEmpty(view: View, value: List<T>?){

  if (value!!.isEmpty()){
        view.visibility=View.VISIBLE
    }
    else{
        view.visibility=View.GONE
    }
}

