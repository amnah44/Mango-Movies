package com.mango.movies.ui.showmore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.mango.movies.R
import com.mango.movies.databinding.FragmentShowMoreBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class ShowMoreFragment :
    BaseFragment<FragmentShowMoreBinding>(R.layout.fragment_show_more) {
    override val LOG_TAG: String = Constant.SHOW_MORE_MOVIES_FRAGMENT

    override fun setupView() {
    }

    override val viewModel: ViewModel
        get() = TODO("Not yet implemented")
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentShowMoreBinding
        get() = TODO("Not yet implemented")
}