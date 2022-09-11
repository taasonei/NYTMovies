package com.github.taasonei.nytmovies.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.taasonei.nytmovies.data.storage.MovieRepositoryImpl
import com.github.taasonei.nytmovies.data.storage.local.LocalMovieDataSourceImpl
import com.github.taasonei.nytmovies.data.storage.local.MovieRoomDatabase
import com.github.taasonei.nytmovies.data.storage.remote.MovieApi
import com.github.taasonei.nytmovies.data.storage.remote.RemoteMovieDataSourceImpl
import com.github.taasonei.nytmovies.domain.GetMoviesUseCase
import com.github.taasonei.nytmovies.domain.LoadAndSaveMoviesUseCase

class MovieListViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val localMovieDataSource =
        LocalMovieDataSourceImpl(database = MovieRoomDatabase.getDatabase(context))
    private val remoteMovieDataSource = RemoteMovieDataSourceImpl(movieApi = MovieApi)

    private val repository = MovieRepositoryImpl(
        remoteMovieDataSource = remoteMovieDataSource,
        localMovieDataSource = localMovieDataSource
    )

    private val getMoviesUseCase = GetMoviesUseCase(repository = repository)
    private val loadAndSaveMoviesUseCase = LoadAndSaveMoviesUseCase(repository = repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieListViewModel(
            getMoviesUseCase = getMoviesUseCase,
            loadAndSaveMoviesUseCase = loadAndSaveMoviesUseCase
        ) as T
    }

}
