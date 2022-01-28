package com.example.whereis.di

import android.content.Context
import com.example.whereis.BuildConfig
import com.example.whereis.data.local.TrackingDao
import com.example.whereis.data.local.TrackingDatabase
import com.example.whereis.data.remote.api.TrackingInfoApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideTrackingDao(context: Context): TrackingDao {
        return TrackingDatabase.getDatabase(context)!!.trackingDao()
    }

}