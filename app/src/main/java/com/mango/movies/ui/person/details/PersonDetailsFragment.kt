package com.mango.movies.ui.person.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPersonDetailsBinding
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class PersonDetailsFragment :
    BaseFragment<FragmentPersonDetailsBinding>(R.layout.fragment_person_details) {
    override val viewModel = PersonDetailsViewModel(repository = MovieRepository)
    override val LOG_TAG: String = Constant.PERSON_DETAILS_FRAGMENT
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonDetailsBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.imageBack.setOnClickListener{ v ->
            Navigation.findNavController(v).popBackStack()
        }
        binding.personDetailsViewModel = viewModel
    }
}