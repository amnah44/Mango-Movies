package com.mango.movies.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentHomeBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val LOG_TAG: String = Constant.HOME_FRAGMENT
    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentHomeBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.homeViewModel = viewModel
        binding.categoryRecycler.adapter = HomeAdapter(mutableListOf(), viewModel)
    }
}