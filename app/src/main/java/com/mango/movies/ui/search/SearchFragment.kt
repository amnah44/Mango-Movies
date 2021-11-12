package com.mango.movies.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSearchBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override val LOG_TAG: String = Constant.SEARCH_FRAGMENT
    override val viewModel by activityViewModels<SearchViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSearchBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.searchRecycler.adapter = SearchAdapter(mutableListOf(), viewModel)
        viewModel.selectedMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                val nav =
                    SearchFragmentDirections.actionSearchFragmentToDetailsFragment(
                        it
                    )
                Navigation.findNavController(requireView()).navigate(nav)
            }
        }
        binding.returnArrow.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
    }

}