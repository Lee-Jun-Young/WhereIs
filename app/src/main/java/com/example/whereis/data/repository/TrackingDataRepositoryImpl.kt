package com.example.whereis.data.repository

import android.app.Application
import com.example.whereis.data.local.LocalTrackingDataSourceImpl
import com.example.whereis.data.local.TrackingDao
import com.example.whereis.data.local.TrackingDatabase
import com.example.whereis.model.TrackingData

class TrackingDataRepositoryImpl(application: Application) : TrackingDataRepository {

    private val localTrackingDataSource = LocalTrackingDataSourceImpl(application)

    override fun insertData(trackingData: TrackingData) =
        localTrackingDataSource.insertData(trackingData)
    
    override fun deleteData(trackingNum: String) =
        localTrackingDataSource.deleteData(trackingNum)

    override suspend fun getDetailData(trackingNum: String?): TrackingData =
        localTrackingDataSource.getDetailData(trackingNum)

    override suspend fun getAllData(): List<TrackingData> =
        localTrackingDataSource.getAllData()

}