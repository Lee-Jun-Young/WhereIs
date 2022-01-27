package com.example.whereis.di

import com.example.whereis.data.remote.RemoteCompanyDataSource
import com.example.whereis.data.remote.RemoteCompanyDataSourceImpl
import com.example.whereis.data.remote.RemoteTrackingInfoDataSource
import com.example.whereis.data.remote.RemoteTrackingInfoDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun providerRemoteCompanyDataSource(remoteCompanyDataSource: RemoteCompanyDataSourceImpl): RemoteCompanyDataSource

    @Binds
    abstract fun providerRemoteTrackingInfoDataSource(remoteTrackingInfoDataSource: RemoteTrackingInfoDataSourceImpl): RemoteTrackingInfoDataSource
}