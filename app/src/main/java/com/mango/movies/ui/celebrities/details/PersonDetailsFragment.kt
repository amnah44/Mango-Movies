package com.mango.movies.ui.celebrities.details


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPersonDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.celebrities.PersonPopularViewModel
import com.mango.movies.util.Constant

class PersonDetailsFragment :
    BaseFragment<FragmentPersonDetailsBinding>(R.layout.fragment_person_details) {

    override val viewModel = PersonPopularViewModel()
    override val LOG_TAG: String = Constant.PERSON_DETAILS_FRAGMENT
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonDetailsBinding =
        DataBindingUtil::inflate

    private val args: PersonDetailsFragmentArgs by navArgs()

    override fun setupView() {
        binding.item = args.personDetails
        binding.returnArrow.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
        binding.recyclerKnownFor.adapter = KnownForAdapter(mutableListOf(), viewModel)
    }

}