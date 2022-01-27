package com.example.whereis.di

import com.example.whereis.data.remote.api.CompanyApi
import com.example.whereis.data.remote.api.TrackingInfoApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCompanyApi(
        okHttpClient: OkHttpClient,
        factory: Converter.Factory
    ): CompanyApi {
        return Retrofit.Builder()
            .baseUrl("http://info.sweettracker.co.kr/")
            .addConverterFactory(factory)
            .client(okHttpClient)
            .build()
            .create(CompanyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTrackingInfoApi(
        okHttpClient: OkHttpClient,
        factory: Converter.Factory
    ): TrackingInfoApi {
        return Retrofit.Builder()
            .baseUrl("http://info.sweettracker.co.kr/")
            .addConverterFactory(factory)
            .client(okHttpClient)
            .build()
            .create(TrackingInfoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

}