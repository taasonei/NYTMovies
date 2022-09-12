package com.github.taasonei.nytmovies.data.storage.remote

import android.util.Log
import com.github.taasonei.nytmovies.data.storage.remote.model.RemoteMovie

class RemoteMovieDataSourceImpl(private val movieApi: MovieApiService) : RemoteMovieDataSource {

    override suspend fun getMovies(): List<RemoteMovie> {
        val reviews = movieApi.getMovies()
        Log.d("tag", "status = ${reviews.status}")
        return if (reviews.status == "OK") {
            reviews.results.map { result ->
                RemoteMovie(
                    title = result.display_title,
                    summary = result.summary_short,
                    src = result.multimedia?.src ?: ""
                )
            }
        } else {
            throw Exception(reviews.status)
        }
    }

}
