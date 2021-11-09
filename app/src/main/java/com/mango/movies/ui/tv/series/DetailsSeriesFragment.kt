package com.mango.movies.ui.tv.series

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSeriesDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant


class DetailsSeriesFragment : BaseFragment<FragmentSeriesDetailsBinding>(R.layout.fragment_series_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT

    override val viewModel: DetailsSeriesViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSeriesDetailsBinding = DataBindingUtil::inflate


    private val args: DetailsSeriesFragmentArgs by navArgs()
    override fun setupView() {

        binding.itemMovie = args.seriesDetails
        Log.i("Amnah", args.seriesDetails.id.toString())
        binding.returnArrow.setOnClickListener{ view ->
            view.findNavController().popBackStack()
        }
    }


}