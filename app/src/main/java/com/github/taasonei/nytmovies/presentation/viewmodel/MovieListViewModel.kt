package com.github.taasonei.nytmovies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.taasonei.nytmovies.domain.GetMoviesUseCase
import com.github.taasonei.nytmovies.domain.LoadAndSaveMoviesUseCase
import com.github.taasonei.nytmovies.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MovieListViewModel(
    getMoviesUseCase: GetMoviesUseCase,
    private val loadAndSaveMoviesUseCase: LoadAndSaveMoviesUseCase
) : ViewModel() {

    val movieList: Flow<List<Movie>> = getMoviesUseCase.execute()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadAndSaveMoviesUseCase.execute()
        }
    }

}