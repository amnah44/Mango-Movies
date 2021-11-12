package com.mango.movies.ui.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mango.movies.R
import com.mango.movies.databinding.FragmentReviewBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class ReviewFragment: BaseFragment<FragmentReviewBinding>(R.layout.fragment_review){
    override val LOG_TAG: String = Constant.REVIEW_FRAGMENT
    override val viewModel by activityViewModels<ReviewViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentReviewBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.apply {
            reviewViewModel = viewModel
            reviewsRecycler.adapter = ReviewAdapter(mutableListOf(), viewModel)
            searchReviewButton.setOnClickListener{
                val action = ReviewFragmentDirections.actionReviewFragmentToSearchReviewFragment2()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
    }
}