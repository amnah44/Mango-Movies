package com.mango.movies.ui.review.searchReview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSearchReviewBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class SearchReviewFragment: BaseFragment<FragmentSearchReviewBinding>(R.layout.fragment_search_review) {
    override val LOG_TAG: String = Constant.SEARCH_REVIEW_FRAGMENT
    override val viewModel: SearchReviewViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSearchReviewBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.apply {
            searchReviewViewModel = viewModel
            searchReviewRecycler.adapter = SearchReviewAdapter(mutableListOf(), viewModel)
        }
    }
}