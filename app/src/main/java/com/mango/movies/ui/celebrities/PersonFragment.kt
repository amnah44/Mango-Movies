package com.mango.movies.ui.celebrities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPersonBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class PersonFragment : BaseFragment<FragmentPersonBinding>(R.layout.fragment_person) {
    override val LOG_TAG: String = Constant.PEOPLE_FRAGMENT
    override val viewModel = PersonPopularViewModel()

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonBinding =
        DataBindingUtil::inflate




    override fun setupView() {
        binding.apply {
            viewModel = viewModel
            personRecyclerView.adapter = PersonAdapter(mutableListOf(), viewModel)
        }


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