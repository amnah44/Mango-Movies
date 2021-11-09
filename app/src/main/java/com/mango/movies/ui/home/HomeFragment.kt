package com.mango.movies.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentHomeBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val LOG_TAG: String = Constant.HOME_FRAGMENT
    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentHomeBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.apply {
            homeViewModel = viewModel
            recyclerUpComingMovies.adapter = UpComingMovieAdapter(mutableListOf(), viewModel)
            recyclerTopRateMovies.adapter = TopRateMovieAdapter(mutableListOf(), viewModel)
            recyclerTrendingSeries.adapter = TrendingSeriesAdapter(mutableListOf(), viewModel)
            recyclerTopRateSeries.adapter = TopRateSeriesAdapter(mutableListOf(), viewModel)
            searchViewBtn.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
        viewModel.movieEvent.observe(this, EventObserve {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
            Navigation.findNavController(requireView()).navigate(action)
        })

        viewModel.seriesEvent.observe(this, EventObserve {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsSeriesFragment(it)
            Navigation.findNavController(requireView()).navigate(action)
        })
    }

}