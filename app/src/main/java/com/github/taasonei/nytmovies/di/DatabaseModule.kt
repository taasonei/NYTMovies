package com.github.taasonei.nytmovies.di

import android.content.Context
import com.github.taasonei.nytmovies.data.storage.local.LocalMovieDataSource
import com.github.taasonei.nytmovies.data.storage.local.LocalMovieDataSourceImpl
import com.github.taasonei.nytmovies.data.storage.local.MovieRoomDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideLocalMovieDataSource(database: MovieRoomDatabase): LocalMovieDataSource {
        return LocalMovieDataSourceImpl(database = database)
    }

    @Provides
    fun provideMovieRoomDatabase(context: Context): MovieRoomDatabase {
        return MovieRoomDatabase.getDatabase(context)
    }

}
