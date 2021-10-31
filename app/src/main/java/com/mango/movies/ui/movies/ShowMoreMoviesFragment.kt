package com.mango.movies.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentHomeBinding
import com.mango.movies.databinding.FragmentShowMoreMoviesBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.home.HomeViewModel
import com.mango.movies.util.Constant

class ShowMoreMoviesFragment :
    BaseFragment<FragmentShowMoreMoviesBinding>(R.layout.fragment_show_more_movies) {
    override val LOG_TAG: String = Constant.SHOW_MORE_MOVIES_FRAGMENT

    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentShowMoreMoviesBinding = DataBindingUtil::inflate

    override fun setupView() {
    }
}