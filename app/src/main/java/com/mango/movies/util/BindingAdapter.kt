package com.mango.movies.util

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mango.movies.R
import com.mango.movies.ui.base.BaseAdapter
import android.widget.RatingBar

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

@BindingAdapter(value = ["imageUrl"])
fun ImageView.seImageFromUrl(url: String?) {
    Glide.with(this)
        .load(Constant.BASE_PERSON_IMAGE_URL + url)
        .placeholder(R.drawable.ic_place_holder)
        .error(R.drawable.ic_error)
        .into(this)
}

@BindingAdapter("navigate")
fun View.navigate(action: NavDirections) {
    this.setOnClickListener {
        Navigation.findNavController(this).navigate(action)
    }
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
