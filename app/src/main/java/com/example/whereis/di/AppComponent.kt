package com.example.whereis.di

import android.content.Context
import com.example.whereis.ui.add.AddActivity
import com.example.whereis.ui.detail.DetailActivity
import com.example.whereis.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, NetworkModule::class, DataSourceModule::class, RoomModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: DetailActivity)
    fun inject(activity: AddActivity)
    fun inject(activity: MainActivity)
}