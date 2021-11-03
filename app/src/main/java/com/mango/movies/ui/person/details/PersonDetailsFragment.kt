package com.mango.movies.ui.person.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPersonDetailsBinding
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.person.PersonPopularViewModel
import com.mango.movies.util.Constant

class PersonDetailsFragment :
    BaseFragment<FragmentPersonDetailsBinding>(R.layout.fragment_person_details) {

    override val viewModel = PersonPopularViewModel(repository = MovieRepository)
    private val args: PersonDetailsFragmentArgs by navArgs()

    override val LOG_TAG: String = Constant.PERSON_DETAILS_FRAGMENT
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonDetailsBinding =
        DataBindingUtil::inflate

    @SuppressLint("CheckResult")
    override fun setupView() {
        binding.personDetailsViewModel = viewModel
        binding.imageBack.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
        binding.apply {
            textActorName.text = args.person.name
            view?.let { Glide.with(it).load(args.person.getImageUrl()).into(imageActor) }
           recyclerKnownFor.adapter = KnownForAdapter(mutableListOf())
        }
    }


}