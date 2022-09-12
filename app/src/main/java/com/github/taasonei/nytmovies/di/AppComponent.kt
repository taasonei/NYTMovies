package com.github.taasonei.nytmovies.di

import com.github.taasonei.nytmovies.presentation.ui.MovieListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DomainModule::class, DataModule::class, DatabaseModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(movieListActivity: MovieListActivity)

}