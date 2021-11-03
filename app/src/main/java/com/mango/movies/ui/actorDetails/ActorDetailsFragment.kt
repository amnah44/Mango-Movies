package com.mango.movies.ui.actorDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.mango.movies.R
import com.mango.movies.databinding.FragmentActorDetailsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.details.DetailsViewModel
import com.mango.movies.util.Constant

class ActorDetailsFragment :
    BaseFragment<FragmentActorDetailsBinding>(R.layout.fragment_actor_details) {
    override val viewModel: DetailsViewModel by viewModels()
    override val LOG_TAG: String = Constant.ACTOR_DETAILS_FRAGMENT
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentActorDetailsBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.returnArrow.setOnClickListener{ view ->
            view.findNavController().popBackStack()
        }
    }


}