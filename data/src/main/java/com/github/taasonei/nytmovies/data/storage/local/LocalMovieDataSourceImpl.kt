package com.github.taasonei.nytmovies.data.storage.local

import com.github.taasonei.nytmovies.data.storage.local.model.DatabaseMovie
import kotlinx.coroutines.flow.Flow

class LocalMovieDataSourceImpl(private val database: MovieRoomDatabase) : LocalMovieDataSource {

    override fun getMovies(): Flow<List<DatabaseMovie>> {
        return database.movieDao().getMovies()
    }

}

