package com.github.taasonei.nytmovies.domain

import com.github.taasonei.nytmovies.domain.repository.MovieRepository

class LoadAndSaveMoviesUseCase(private val repository: MovieRepository) {

    suspend fun execute() {
        repository.loadAndSaveMovies()
    }

}
