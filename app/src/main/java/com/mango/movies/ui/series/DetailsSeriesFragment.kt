package com.mango.movies.ui.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSeriesDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve

class DetailsSeriesFragment :
    BaseFragment<FragmentSeriesDetailsBinding>(R.layout.fragment_series_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT
    override val viewModel by activityViewModels<DetailsSeriesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSeriesDetailsBinding =
        DataBindingUtil::inflate
    private val args: DetailsSeriesFragmentArgs by navArgs()

    override fun setupView() {
        val series = args.seriesDetails
        series.id?.let { viewModel.getSimilarSeries(it) }
        binding.recyclerRelated.adapter = SimilarSeriesAdapter(mutableListOf(), viewModel)
        binding.itemSeries = series
        binding.returnArrow.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
        viewModel.selectedSeriesEvent.observe(this, EventObserve {
            val nav =
                DetailsSeriesFragmentDirections.actionDetailsSeriesFragmentToDetailsSeriesFragment(
                    it
                )
            Navigation.findNavController(requireView()).navigate(nav)
        })
    }
}