package com.github.taasonei.nytmovies.data.storage.local

import com.github.taasonei.nytmovies.data.storage.local.model.DatabaseMovie
import kotlinx.coroutines.flow.Flow

interface LocalMovieDataSource {

    fun getMovies(): Flow<List<DatabaseMovie>>

}
