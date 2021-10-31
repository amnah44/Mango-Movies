package com.mango.movies.util

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mango.movies.ui.base.BaseAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@BindingAdapter(value = ["app:showOnLoading"])
fun <T>showOnLoading(view: View, state: State<T>?){
    if (state is State.Loading)
        view.visibility= View.VISIBLE
    else
        view.visibility= View.GONE
}

@BindingAdapter(value = ["app:showOnError"])
fun <T>showOnError(view: View, state: State<T>?){
    if (state is State.Error)
        view.visibility= View.VISIBLE
    else
        view.visibility= View.GONE
}

@BindingAdapter(value = ["app:showOnSuccess"])
fun <T>showOnSuccess(view: View, state: State<T>?){
    if (state is State.Success)
        view.visibility= View.VISIBLE
    else
        view.visibility= View.GONE
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
fun <T> getYearFromDateString(view: TextView, dateStr: String? ) {
    val date = LocalDate.parse(dateStr)
    view.text  = date.year.toString()
}