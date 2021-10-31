package com.mango.movies.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentFavoritesBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>(R.layout.fragment_favorites) {
    override val LOG_TAG: String = Constant.FAVORITES_FRAGMENT

    override val viewModel: FavoriteViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentFavoritesBinding = DataBindingUtil::inflate

    override fun setupView() {
    }
}