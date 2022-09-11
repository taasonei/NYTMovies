package com.github.taasonei.nytmovies.data.remote

import com.github.taasonei.nytmovies.data.remote.model.RemoteMovie

interface RemoteMovieDataSource {

    suspend fun getMovies(): List<RemoteMovie>

}