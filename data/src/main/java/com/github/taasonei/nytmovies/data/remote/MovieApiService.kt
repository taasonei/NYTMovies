package com.github.taasonei.nytmovies.data.remote

import com.github.taasonei.nytmovies.data.remote.model.Reviews
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"
private const val PATH = "reviews/all.json?api-key=gpoxZbFVhADJJCmCGa3wTyCc7Tibv0Yp"

private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface MovieApiService {
    @GET(PATH)
    suspend fun getMovies(): Reviews
}

object MovieApi {
    val retrofitService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}