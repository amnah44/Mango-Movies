package com.mango.movies.ui.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentShowMoreMoviesBinding
import com.mango.movies.databinding.FragmentShowMoreSeriesBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.home.HomeViewModel
import com.mango.movies.util.Constant

class ShowMoreSeriesFragment :
    BaseFragment<FragmentShowMoreSeriesBinding>(R.layout.fragment_show_more_series) {
    override val LOG_TAG: String = Constant.SHOW_MORE_SERIES_FRAGMENT

    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentShowMoreSeriesBinding = DataBindingUtil::inflate

    override fun setupView() {
    }
}