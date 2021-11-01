package com.mango.movies.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.mango.movies.R
import com.mango.movies.databinding.FragmentSettingsBinding
import com.mango.movies.ui.base.BaseFragment
import com.mango.movies.util.Constant

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {
    override val LOG_TAG: String = Constant.SETTINGS_FRAGMENT

    override val viewModel: SettingsViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSettingsBinding = DataBindingUtil::inflate

    override fun setupView() {
    }
}