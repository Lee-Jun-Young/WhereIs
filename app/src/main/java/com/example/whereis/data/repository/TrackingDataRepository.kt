package com.example.whereis.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.whereis.data.local.TrackingDao
import com.example.whereis.data.local.TrackingDatabase
import com.example.whereis.model.TrackingData

class TrackingDataRepository(application: Application) {

    private val trackingDao: TrackingDao = TrackingDatabase.getDatabase(application)!!.trackingDao()

    fun insertData(trackingData: TrackingData){
        trackingDao.insertData(trackingData)
    }

    fun deleteData(trackingNum: String){
        trackingDao.deleteData(trackingNum)
    }

    suspend fun getDetailData(trackingNum: String?): TrackingData {
        return trackingDao.getDetailData(trackingNum)
    }

    suspend fun getAllData() : List<TrackingData> {
        return trackingDao.getAll()
    }
}