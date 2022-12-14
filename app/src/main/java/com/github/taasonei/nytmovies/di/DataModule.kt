package com.github.taasonei.nytmovies.di

import com.github.taasonei.nytmovies.data.storage.MovieRepositoryImpl
import com.github.taasonei.nytmovies.data.storage.local.LocalMovieDataSource
import com.github.taasonei.nytmovies.data.storage.remote.RemoteMovieDataSource
import com.github.taasonei.nytmovies.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        remoteMovieDataSource: RemoteMovieDataSource,
        localMovieDataSource: LocalMovieDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            remoteMovieDataSource = remoteMovieDataSource,
            localMovieDataSource = localMovieDataSource
        )
    }

}
