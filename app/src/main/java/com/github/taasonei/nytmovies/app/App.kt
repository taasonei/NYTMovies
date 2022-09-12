package com.github.taasonei.nytmovies.app

import android.app.Application
import com.github.taasonei.nytmovies.di.AppComponent
import com.github.taasonei.nytmovies.di.AppModule
import com.github.taasonei.nytmovies.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

       appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }

}
