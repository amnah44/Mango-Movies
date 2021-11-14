package com.mango.movies.ui.review.searchReview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSearchReviewBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class SearchReviewFragment: BaseFragment<FragmentSearchReviewBinding>(R.layout.fragment_search_review) {
    override val LOG_TAG: String = Constant.SEARCH_REVIEW_FRAGMENT
    override val viewModel by activityViewModels<SearchReviewViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSearchReviewBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.let {
            it.viewModel = viewModel
            it.searchReviewRecycler.adapter = SearchReviewAdapter(mutableListOf(), viewModel)
            it.returnArrow.setOnClickListener { view ->
                view.findNavController().popBackStack()
            }
        }
    }
}