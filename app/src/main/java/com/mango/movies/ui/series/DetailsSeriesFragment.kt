package com.mango.movies.ui.series

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSeriesDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class DetailsSeriesFragment :
    BaseFragment<FragmentSeriesDetailsBinding>(R.layout.fragment_series_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT
    override val viewModel: DetailsSeriesViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSeriesDetailsBinding =
        DataBindingUtil::inflate
    private val args: DetailsSeriesFragmentArgs by navArgs()

    override fun setupView() {
        val series = args.seriesDetails
        viewModel.getSimilarSeries(series.id!!)
        binding.recyclerRelated.adapter = SimilarSeriesAdapter(mutableListOf(), viewModel)
        binding.itemSeries = series
        binding.returnArrow.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
        viewModel.selectedSeries.observe(viewLifecycleOwner) {
            if (it != null) {
                val nav =
                    DetailsSeriesFragmentDirections.actionDetailsSeriesFragmentToDetailsSeriesFragment(
                        it
                    )
                Navigation.findNavController(requireView()).navigate(nav)
            }
        }
    }
}