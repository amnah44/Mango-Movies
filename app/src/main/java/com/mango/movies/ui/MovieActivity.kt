package com.mango.movies.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mango.movies.R
import com.mango.movies.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.parent_container)
        _binding.bottomNav.setupWithNavController(navController)
    }
}