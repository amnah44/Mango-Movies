package com.mango.movies.ui.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPeopleBinding
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.person.details.PersonDetailsFragment
import com.mango.movies.util.Constant

class PersonFragment : BaseFragment<FragmentPeopleBinding>(R.layout.fragment_people) {
    override val LOG_TAG: String = Constant.PEOPLE_FRAGMENT
    override val viewModel = PersonPopularViewModel(repository = MovieRepository)
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPeopleBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.personViewModel = viewModel
        binding.personRecyclerView.adapter = PersonAdapter(mutableListOf(), viewModel)

        viewModel.personDetails.observe(viewLifecycleOwner) {
            if(it!=null){
                val nav = PersonFragmentDirections.actionPersonFragmentToPersonDetailsFragment(it)
                Navigation.findNavController(requireView()).navigate(nav)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.personDetails.value = null
    }
}