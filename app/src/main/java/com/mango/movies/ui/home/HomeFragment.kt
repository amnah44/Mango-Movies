package com.mango.movies.ui.home

import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentHomeBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

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
            recyclerLatestSeries.adapter = TopRateSeriesAdapter(mutableListOf(), viewModel)
                binding.imageTheme.setOnClickListener{
                    when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                        Configuration.UI_MODE_NIGHT_YES ->{
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        }
                        Configuration.UI_MODE_NIGHT_NO ->{
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        }
                    }
                }
        }

        viewModel.movieDetails.observe(viewLifecycleOwner){
            if (it != null){
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
                Navigation.findNavController(requireView()).navigate(action)
            }
        }

        viewModel.seriesDetails.observe(viewLifecycleOwner){
            if (it != null){
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsSeriesFragment(it)
                Navigation.findNavController(requireView()).navigate(action)
            }
        }
    }

}