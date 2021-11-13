package com.mango.movies.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentMoviesDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant
import com.mango.movies.util.EventObserve

class DetailsMoviesFragment :
    BaseFragment<FragmentMoviesDetailsBinding>(R.layout.fragment_movies_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT
    override val viewModel: DetailsMoviesViewModel by activityViewModels<DetailsMoviesViewModel>()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentMoviesDetailsBinding =
        DataBindingUtil::inflate
    private val args: DetailsMoviesFragmentArgs by navArgs()

    override fun setupView() {
        val movie = args.movieDetails
        viewModel.getSimilarMovie(movie.id!!)
        binding.apply {
            viewModel = this@DetailsMoviesFragment.viewModel
            recyclerRelated.adapter = SimilarMovieAdapter(mutableListOf(), viewModel)
            itemMovie = movie
            returnArrow.setOnClickListener { view ->
                view.findNavController().popBackStack()
            }
        }
        viewModel.selectedMovieEvent.observe(this, EventObserve {
            val nav =
                DetailsMoviesFragmentDirections.actionDetailsFragmentToDetailsFragment(
                    it
                )
            Navigation.findNavController(requireView()).navigate(nav)
        })
    }
}