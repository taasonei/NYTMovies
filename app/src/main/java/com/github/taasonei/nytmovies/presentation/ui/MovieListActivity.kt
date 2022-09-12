package com.github.taasonei.nytmovies.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.taasonei.nytmovies.R
import com.github.taasonei.nytmovies.databinding.ActivityMovieListBinding

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}