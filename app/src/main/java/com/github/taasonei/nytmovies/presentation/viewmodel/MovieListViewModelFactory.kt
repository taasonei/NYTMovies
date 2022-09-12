package com.github.taasonei.nytmovies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.taasonei.nytmovies.domain.GetMoviesUseCase
import com.github.taasonei.nytmovies.domain.LoadAndSaveMoviesUseCase

class MovieListViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val loadAndSaveMoviesUseCase: LoadAndSaveMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(
            getMoviesUseCase = getMoviesUseCase,
            loadAndSaveMoviesUseCase = loadAndSaveMoviesUseCase
        ) as T
    }

}
