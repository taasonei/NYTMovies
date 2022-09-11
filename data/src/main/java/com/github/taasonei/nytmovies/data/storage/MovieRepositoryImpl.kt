package com.github.taasonei.nytmovies.data.storage

import com.github.taasonei.nytmovies.data.storage.local.LocalMovieDataSource
import com.github.taasonei.nytmovies.data.storage.local.model.asMovieList
import com.github.taasonei.nytmovies.data.storage.remote.RemoteMovieDataSource
import com.github.taasonei.nytmovies.data.storage.remote.model.asDatabaseMovieList
import com.github.taasonei.nytmovies.domain.model.Movie
import com.github.taasonei.nytmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource
) : MovieRepository {

    override suspend fun loadAndSaveMovies() {
        val remoteMovies = remoteMovieDataSource.getMovies()
        localMovieDataSource.insertMovies(remoteMovies.asDatabaseMovieList())
    }

    override fun getMovies(): Flow<List<Movie>> {
        return localMovieDataSource.getMovies().map { list -> list.asMovieList() }
    }

}
