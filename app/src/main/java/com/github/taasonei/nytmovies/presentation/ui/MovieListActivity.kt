package com.github.taasonei.nytmovies.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import com.github.taasonei.nytmovies.app.App
import com.github.taasonei.nytmovies.databinding.ActivityMovieListBinding
import com.github.taasonei.nytmovies.presentation.adapter.MovieAdapter
import com.github.taasonei.nytmovies.presentation.viewmodel.MovieListViewModel
import com.github.taasonei.nytmovies.presentation.viewmodel.MovieListViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieListViewModelFactory
    private lateinit var viewModel: MovieListViewModel

    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, factory).get(MovieListViewModel::class.java)

        val adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter

        lifecycle.coroutineScope.launch {
            viewModel.movieList.collect { list ->
                adapter.submitList(list)
            }
        }
    }

}