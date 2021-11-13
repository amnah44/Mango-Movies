package com.mango.movies.ui.categoris.movieTab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentTabMovieBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.categoris.CategoryFragmentDirections
import com.mango.movies.ui.categoris.GenreAdapter
import com.mango.movies.ui.categoris.MovieAndTvResultAdapter
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve
import com.mango.movies.util.State

class MovieTabFragment:BaseFragment<FragmentTabMovieBinding>(R.layout.fragment_tab_movie){
    override val LOG_TAG: String= Constant.MOVIE_TAB_FRAGMENT
    override val viewModel: MovieViewModel by activityViewModels()
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