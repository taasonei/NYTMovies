package com.github.taasonei.nytmovies.di

import com.github.taasonei.nytmovies.domain.GetMoviesUseCase
import com.github.taasonei.nytmovies.domain.LoadAndSaveMoviesUseCase
import com.github.taasonei.nytmovies.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetMovieUseCase(repository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository = repository)
    }

    @Provides
    fun provideLoadAndSaveMoviesUseCase(repository: MovieRepository): LoadAndSaveMoviesUseCase {
        return LoadAndSaveMoviesUseCase(repository = repository)
    }

}
