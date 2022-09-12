package com.github.taasonei.nytmovies.data.storage.remote

import com.github.taasonei.nytmovies.data.storage.remote.model.Reviews
import retrofit2.http.GET

private const val PATH = "reviews/all.json?api-key=gpoxZbFVhADJJCmCGa3wTyCc7Tibv0Yp"

interface MovieApiService {
    @GET(PATH)
    suspend fun getMovies(): Reviews
}
