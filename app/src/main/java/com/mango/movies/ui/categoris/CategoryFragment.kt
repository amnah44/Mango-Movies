package com.mango.movies.ui.categoris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.mango.movies.R
import com.mango.movies.databinding.FragmentCategoryBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    override val LOG_TAG: String = Constant.CATEGORY_FRAGMENT

    override fun setupView() {
    }

    override val viewModel: ViewModel
        get() = TODO("Not yet implemented")
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCategoryBinding
        get() = TODO("Not yet implemented")

}