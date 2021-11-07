package com.mango.movies.ui.categoris

import com.mango.movies.R
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener
import com.mango.movies.model.domain.category.Result

class MovieAndTvResultAdapter(
    item:List<Result>,
    listener:ResultInteractionListener
):BaseAdapter<Result>(item,listener){
    override val layoutId: Int = R.layout.item_category

}


interface ResultInteractionListener: BaseInteractionListener {
    fun onClickItem()
}