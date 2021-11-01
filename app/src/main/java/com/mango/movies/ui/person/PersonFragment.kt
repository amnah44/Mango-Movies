package com.mango.movies.ui.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentPeopleBinding
import com.mango.movies.model.repositiory.MovieRepository
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class PersonFragment : BaseFragment<FragmentPeopleBinding>(R.layout.fragment_people) {
    override val LOG_TAG: String = Constant.PEOPLE_FRAGMENT
    override val viewModel: PersonPopularViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentPeopleBinding = DataBindingUtil::inflate

    override fun setupView() {
        binding.personViewModel = viewModel
        binding.personRecyclerView.adapter = PersonAdapter(mutableListOf(),viewModel)
    }
}