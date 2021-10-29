package com.mango.movies

import com.mango.movies.databinding.FragmentFavoritesBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>(R.layout.fragment_favorites) {
    override val LOG_TAG: String = Constant.FAVORITES_FRAGMENT

    override fun setupView() {
    }
}