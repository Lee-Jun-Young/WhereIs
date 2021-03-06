package com.example.whereis.data.local

import android.content.Context
import com.example.whereis.model.TrackingData
import javax.inject.Inject

class LocalTrackingDataSourceImpl @Inject constructor(private val trackingDao: TrackingDao) :
    LocalTrackingDataSource {

    override fun insertData(trackingData: TrackingData) {
        trackingDao.insertData(trackingData)
    }

    override fun deleteData(trackingNum: String) {
        trackingDao.deleteData(trackingNum)
    }

    override suspend fun getDetailData(trackingNum: String?): TrackingData {
        return trackingDao.getDetailData(trackingNum)
    }

    override suspend fun getAllData(): List<TrackingData> {
        return trackingDao.getAll()
    }

}