package com.github.taasonei.nytmovies.di

import android.content.Context
import com.github.taasonei.nytmovies.domain.GetMoviesUseCase
import com.github.taasonei.nytmovies.domain.LoadAndSaveMoviesUseCase
import com.github.taasonei.nytmovies.presentation.viewmodel.MovieListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideMovieListViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        loadAndSaveMoviesUseCase: LoadAndSaveMoviesUseCase
    ): MovieListViewModelFactory {
        return MovieListViewModelFactory(
            getMoviesUseCase = getMoviesUseCase,
            loadAndSaveMoviesUseCase = loadAndSaveMoviesUseCase
        )
    }

}
