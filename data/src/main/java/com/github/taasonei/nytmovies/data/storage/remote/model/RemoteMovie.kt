package com.github.taasonei.nytmovies.data.storage.remote.model

import com.github.taasonei.nytmovies.data.storage.local.model.DatabaseMovie

data class RemoteMovie(
    val title: String = "",
    val summary: String = "",
    val src: String = ""
)

fun List<RemoteMovie>.asDatabaseMovieList(): List<DatabaseMovie> {
    return this.map { remoteMovie ->
        DatabaseMovie(
            title = remoteMovie.title,
            summary = remoteMovie.summary,
            src = remoteMovie.src
        )
    }
}

