package com.mango.movies.ui.categoris

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayout
import com.mango.movies.R
import com.mango.movies.databinding.FragmentCategoryBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.ui.categoris.movieTab.MovieTabFragment
import com.mango.movies.ui.categoris.seriesTab.SeriesTabFragment
import com.mango.movies.util.Constant

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {
    override val LOG_TAG: String = Constant.CATEGORY_FRAGMENT
    override val viewModel: ResultViewModel by activityViewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        DataBindingUtil::inflate

    override fun setupView() {
        binding.viewModel = viewModel
        val movieTab=binding.myTabsLayout.newTab()
        movieTab.setText("Movie")
        binding.myTabsLayout.addTab(movieTab)
        val seriesTab=binding.myTabsLayout.newTab()
        seriesTab.setText("series")
        binding.myTabsLayout.addTab(seriesTab)

        replaceFragment(MovieTabFragment())
        binding.myTabsLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                setCurrenTabFragment(tab?.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.i("hddd","gggg")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.i("hddd","gggg")
            }

        })

    }

    private fun setCurrenTabFragment(position: Int?) {
        when(position){
            0 -> replaceFragment(MovieTabFragment())
            1 -> replaceFragment(SeriesTabFragment())
            else -> replaceFragment(MovieTabFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction=requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }
}