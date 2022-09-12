package com.github.taasonei.nytmovies.di

import com.github.taasonei.nytmovies.presentation.ui.MovieListActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DatabaseModule::class, DatabaseModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(movieListActivity: MovieListActivity)

}