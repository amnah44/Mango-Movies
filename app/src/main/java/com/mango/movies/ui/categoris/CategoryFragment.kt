package com.mango.movies.ui.categoris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mango.movies.R
import com.mango.movies.databinding.FragmentCategoryBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve
import com.mango.movies.util.State

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    override val LOG_TAG: String = Constant.CATEGORY_FRAGMENT
    override val viewModel: ResultViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.viewModel = viewModel
        val movieTab=binding.myTabsLayout.newTab()
        movieTab.setText("Movie")
        binding.myTabsLayout.addTab(movieTab)
        val seriesTab=binding.myTabsLayout.newTab()
        seriesTab.setText("series")
        binding.myTabsLayout.addTab(seriesTab)

    }
}