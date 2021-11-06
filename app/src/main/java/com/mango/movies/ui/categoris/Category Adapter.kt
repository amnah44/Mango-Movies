package com.mango.movies.ui.categoris

import com.mango.movies.R
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener

class CategoryAdapter(
    item:List<Result>,
    listener:CategoryInteractionListener
):BaseAdapter<Result>(item,listener){
    override val layoutId: Int = R.layout.item_category

}


interface CategoryInteractionListener: BaseInteractionListener {
    fun onClickItem()
}