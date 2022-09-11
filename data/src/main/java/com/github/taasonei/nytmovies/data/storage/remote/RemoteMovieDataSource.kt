package com.github.taasonei.nytmovies.data.storage.remote

import com.github.taasonei.nytmovies.data.storage.remote.model.RemoteMovie

interface RemoteMovieDataSource {

    suspend fun getMovies(): List<RemoteMovie>

}