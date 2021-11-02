package com.mango.movies.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSearchBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override val LOG_TAG: String = Constant.SEARCH_FRAGMENT
    override val viewModel: SearchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSearchBinding = DataBindingUtil::inflate

    override fun setupView() {
        binding.searchRecycler.adapter = SearchAdapter(mutableListOf(), viewModel)
    }



}