package com.mango.movies.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentDetailsBinding
import com.mango.movies.databinding.FragmentSearchBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.search.SearchViewModel
import com.mango.movies.util.Constant


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT

    override val viewModel: DetailsViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentDetailsBinding = DataBindingUtil::inflate

    override fun setupView() {}
}