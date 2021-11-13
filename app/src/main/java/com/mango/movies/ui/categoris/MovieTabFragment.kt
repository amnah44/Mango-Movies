package com.mango.movies.ui.categoris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentTabMovieBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve
import com.mango.movies.util.State

class MovieTabFragment:BaseFragment<FragmentTabMovieBinding>(R.layout.fragment_tab_movie){
    override val LOG_TAG: String= Constant.MOVIE_TAB_FRAGMENT
    override val viewModel: MovieViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentTabMovieBinding=DataBindingUtil::inflate

    override fun setupView() {
        binding.viewModel=viewModel
        binding.recyclerMovies.adapter = MovieAndTvResultAdapter(mutableListOf(), viewModel)
        binding.recyclerGenre.adapter = GenreAdapter(mutableListOf(), viewModel)
        viewModel.selectedMovieEvent.observe(this, EventObserve {
            if (it is State.Success) {
                val action = CategoryFragmentDirections.actionCategoryFragmentToDetailsFragment(
                    requireNotNull(it.toData())
                )
                Navigation.findNavController(requireView()).navigate(action)
            }
        })

    }

}