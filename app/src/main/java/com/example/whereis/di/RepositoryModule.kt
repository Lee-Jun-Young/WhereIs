package com.example.whereis.di

import com.example.whereis.data.repository.*
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideTrackingDataRepository(trackingDataRepository: TrackingDataRepositoryImpl): TrackingDataRepository

    @Binds
    abstract fun provideTrackingInfoRepository(trackingInfoRepository: TrackingInfoRepositoryImpl): TrackingInfoRepository

    @Binds
    abstract fun provideCompanyRepository(companyRepository: CompanyRepositoryImpl): CompanyRepository

}