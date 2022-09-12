package com.github.taasonei.nytmovies.di

import com.github.taasonei.nytmovies.data.storage.remote.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"

@Module
class NetworkModule {

    @Provides
    fun provideRemoteMovieDataSource(movieApi: MovieApiService): RemoteMovieDataSource {
        return RemoteMovieDataSourceImpl(movieApi = movieApi)
    }

    @Provides
    @Singleton
    fun provideMovieApi(moshi: Moshi): MovieApiService {
        val retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

}
