package com.github.taasonei.nytmovies.data.remote.model

data class Result(
    val display_title: String,
    val summary_short: String,
    val multimedia: Multimedia?,
)