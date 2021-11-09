package com.mango.movies.ui.details

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.search.SearchAdapter
import com.mango.movies.ui.search.SearchFragmentDirections
import com.mango.movies.util.Constant


class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {
    override val LOG_TAG: String = Constant.DETAILS_FRAGMENT

    override val viewModel: DetailsViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentDetailsBinding = DataBindingUtil::inflate


    private val args: DetailsFragmentArgs by navArgs()
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
                val nav = DetailsFragmentDirections.actionDetailsFragmentToDetailsFragment(it)
                Navigation.findNavController(requireView()).navigate(nav)
            }
        }
    }
}