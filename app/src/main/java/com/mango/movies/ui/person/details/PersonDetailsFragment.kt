package com.mango.movies.ui.person.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPersonDetailsBinding
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.person.PersonFragmentDirections
import com.mango.movies.util.Constant

class PersonDetailsFragment :
    BaseFragment<FragmentPersonDetailsBinding>(R.layout.fragment_person_details) {


    override val viewModel = PersonDetailsViewModel(repository = MovieRepository)
    override val LOG_TAG: String = Constant.PERSON_DETAILS_FRAGMENT
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonDetailsBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.imageBack.setOnClickListener{
            view?.let { it1 -> Navigation.findNavController(it1).popBackStack() }
        }
        binding.personDetailsViewModel = viewModel
    }
}