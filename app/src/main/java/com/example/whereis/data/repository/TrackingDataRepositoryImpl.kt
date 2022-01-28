package com.example.whereis.data.repository

import com.example.whereis.data.local.LocalTrackingDataSourceImpl
import com.example.whereis.model.TrackingData
import javax.inject.Inject

class TrackingDataRepositoryImpl @Inject constructor(private val localTrackingDataSource: LocalTrackingDataSourceImpl) :
    TrackingDataRepository {

    override fun insertData(trackingData: TrackingData) =
        localTrackingDataSource.insertData(trackingData)

    override fun deleteData(trackingNum: String) =
        localTrackingDataSource.deleteData(trackingNum)

    override suspend fun getDetailData(trackingNum: String?): TrackingData =
        localTrackingDataSource.getDetailData(trackingNum)

    override suspend fun getAllData(): List<TrackingData> =
        localTrackingDataSource.getAllData()

}