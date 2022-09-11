package com.github.taasonei.nytmovies.domain

import com.github.taasonei.nytmovies.domain.model.Movie
import com.github.taasonei.nytmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val repository: MovieRepository) {

    fun execute(): Flow<List<Movie>> {
        return repository.getMovies()
    }

}
