package com.mango.movies.ui.celebrities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentCelebrityBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve

class CelebrityFragment : BaseFragment<FragmentCelebrityBinding>(R.layout.fragment_celebrity) {
    override val LOG_TAG: String = Constant.PEOPLE_FRAGMENT
    override val viewModel = CelebrityPopularViewModel()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCelebrityBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.apply {
            viewModel = viewModel
            personRecyclerView.adapter = CelebrityAdapter(mutableListOf(), viewModel)
        }
        viewModel.personEvent.observe(this, EventObserve {
            val nav =
                CelebrityFragmentDirections.actionCelebrityFragmentToCelebrityDetailsFragment(it)
            Navigation.findNavController(requireView()).navigate(nav)
        })
    }
}