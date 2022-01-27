package com.example.whereis.data.local

import android.content.Context
import com.example.whereis.model.TrackingData

class LocalTrackingDataSourceImpl(context: Context): LocalTrackingDataSource {

    private val trackingDao: TrackingDao = TrackingDatabase.getDatabase(context)!!.trackingDao()

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