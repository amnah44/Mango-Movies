package com.mango.movies.ui.categoris

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.mango.movies.R
import com.mango.movies.databinding.FragmentTabMovieBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class MovieTabFragment:BaseFragment<FragmentTabMovieBinding>(R.layout.fragment_tab_movie){
    override val LOG_TAG: String= Constant.MOVIE_TAB_FRAGMENT
    override val viewModel: MovieViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentTabMovieBinding=DataBindingUtil::inflate

    override fun setupView() {
        TODO("Not yet implemented")
    }

}