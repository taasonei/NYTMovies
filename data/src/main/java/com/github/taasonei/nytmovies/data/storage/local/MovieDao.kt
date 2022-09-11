package com.github.taasonei.nytmovies.data.storage.local

import androidx.room.Dao
import androidx.room.Query
import com.github.taasonei.nytmovies.data.storage.local.model.DatabaseMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getMovies(): Flow<List<DatabaseMovie>>

}
