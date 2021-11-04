package com.mango.movies.ui.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPersonBinding
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class PersonFragment : BaseFragment<FragmentPersonBinding>(R.layout.fragment_person) {
    override val LOG_TAG: String = Constant.PEOPLE_FRAGMENT
    override val viewModel = PersonPopularViewModel(repository = MovieRepository)
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPersonBinding = DataBindingUtil::inflate

    override fun setupView() {
        binding.personViewModel = viewModel
        binding.personRecyclerView.adapter = PersonAdapter(mutableListOf(),viewModel)
    }
}