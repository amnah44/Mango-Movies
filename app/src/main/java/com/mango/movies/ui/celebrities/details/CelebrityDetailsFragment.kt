package com.mango.movies.ui.celebrities.details


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mango.movies.R
import com.mango.movies.databinding.FragmentCelebrityDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.celebrities.CelebrityPopularViewModel
import com.mango.movies.util.Constant

class CelebrityDetailsFragment :
    BaseFragment<FragmentCelebrityDetailsBinding>(R.layout.fragment_celebrity_details) {

    override val viewModel = CelebrityPopularViewModel()
    override val LOG_TAG: String = Constant.PERSON_DETAILS_FRAGMENT
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCelebrityDetailsBinding =
        DataBindingUtil::inflate

    private val args: CelebrityDetailsFragmentArgs by navArgs()

    override fun setupView() {
        binding.item = args.celebrityDetails
        binding.returnArrow.setOnClickListener { view ->
            view.findNavController().popBackStack()
        }
        binding.recyclerKnownFor.adapter = KnownForAdapter(mutableListOf(), viewModel)
    }

}