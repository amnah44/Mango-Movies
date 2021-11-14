package com.mango.movies.ui.categoris.seriesTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentTabSeriesBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.categoris.CategoryFragmentDirections
import com.mango.movies.ui.categoris.GenreAdapter
import com.mango.movies.ui.categoris.MovieAndTvResultAdapter
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve
import com.mango.movies.util.State

class SeriesTabFragment:BaseFragment<FragmentTabSeriesBinding>(R.layout.fragment_tab_series) {
    override val LOG_TAG: String= Constant.SERIES_TAB_FRAGMENT
    override val viewModel: SeriesViewModel by activityViewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentTabSeriesBinding=DataBindingUtil::inflate

    override fun setupView() {
        binding.viewModel=viewModel
        binding.recyclerSeries.adapter = MovieAndTvResultAdapter(mutableListOf(), viewModel)
        binding.recyclerGenre.adapter = GenreAdapter(mutableListOf(), viewModel)
        viewModel.selectedSeriesEvent.observe(this, EventObserve {
            if (it is State.Success) {
                val action =
                    CategoryFragmentDirections.actionCategoryFragmentToDetailsSeriesFragment(
                        requireNotNull(it.toData())
                    )
                Navigation.findNavController(requireView()).navigate(action)
            }
        })
    }
}