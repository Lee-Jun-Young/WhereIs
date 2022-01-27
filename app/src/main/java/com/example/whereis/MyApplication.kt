package com.example.whereis

import android.app.Application
import com.example.whereis.di.AppComponent
import com.example.whereis.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}