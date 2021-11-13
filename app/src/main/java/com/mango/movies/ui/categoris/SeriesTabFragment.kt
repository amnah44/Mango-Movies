package com.mango.movies.ui.categoris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.mango.movies.R
import com.mango.movies.databinding.FragmentTabSeriesBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class SeriesTabFragment:BaseFragment<FragmentTabSeriesBinding>(R.layout.fragment_tab_series) {
    override val LOG_TAG: String= Constant.SERIES_TAB_FRAGMENT
    override val viewModel:SeriesViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentTabSeriesBinding=DataBindingUtil::inflate

    override fun setupView() {
        binding.viewModel=viewModel
        TODO("Not yet implemented")
    }
}