package com.github.taasonei.nytmovies.domain.repository

import com.github.taasonei.nytmovies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<List<Movie>>

    suspend fun loadAndSaveMovies()

}