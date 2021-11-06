package com.mango.movies.ui.categoris

import com.mango.movies.R
import com.mango.movies.ui.base.BaseAdapter
import com.mango.movies.ui.base.BaseInteractionListener




interface CategoryInteractionListener: BaseInteractionListener {
    fun onClickItem()
}