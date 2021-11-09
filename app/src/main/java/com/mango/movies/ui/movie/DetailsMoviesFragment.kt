package com.mango.movies.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentMoviesDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class DetailsMoviesFragment : BaseFragment<FragmentMoviesDetailsBinding>(R.layout.fragment_movies_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT
    override val viewModel: DetailsMoviesViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentMoviesDetailsBinding = DataBindingUtil::inflate
    private val args: DetailsMoviesFragmentArgs by navArgs()

    override fun setupView() {
        val movie = args.movieDetails
        viewModel.getSimilarMovie(movie.id!!)

        binding.recyclerRelated.adapter = SimilarMovieAdapter(mutableListOf(), viewModel)

        binding.itemMovie = movie
        binding.returnArrow.setOnClickListener{ view ->
            view.findNavController().popBackStack()
        }

        viewModel.selectedMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                val nav =
                    DetailsMoviesFragmentDirections.actionDetailsFragmentToDetailsFragment(
                        it
                    )
                Navigation.findNavController(requireView()).navigate(nav)
            }
        }
    }
}