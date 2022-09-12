package com.github.taasonei.nytmovies.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import com.github.taasonei.nytmovies.databinding.ActivityMovieListBinding
import com.github.taasonei.nytmovies.presentation.adapter.MovieAdapter
import com.github.taasonei.nytmovies.presentation.viewmodel.MovieListViewModel
import com.github.taasonei.nytmovies.presentation.viewmodel.MovieListViewModelFactory
import kotlinx.coroutines.launch

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding
    private val viewModel: MovieListViewModel by viewModels { MovieListViewModelFactory(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieAdapter()
        binding.recyclerView.adapter = MovieAdapter()

        lifecycle.coroutineScope.launch {
            viewModel.movieList.collect { list ->
                adapter.submitList(list)
            }
        }
    }

}