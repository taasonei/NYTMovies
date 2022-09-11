package com.github.taasonei.nytmovies.data.remote.model

data class Reviews(
    val status: String,
    val results: List<Result>
)