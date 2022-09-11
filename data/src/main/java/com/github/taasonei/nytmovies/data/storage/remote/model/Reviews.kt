package com.github.taasonei.nytmovies.data.storage.remote.model

data class Reviews(
    val status: String,
    val results: List<Result>
)