package com.example.whereis.data.repository

import android.app.Application
import com.example.whereis.data.local.TrackingDao
import com.example.whereis.data.local.TrackingDatabase
import com.example.whereis.model.TrackingData

class TrackingDataRepositoryImpl(application: Application) : TrackingDataRepository {

    private val trackingDao: TrackingDao = TrackingDatabase.getDatabase(application)!!.trackingDao()

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