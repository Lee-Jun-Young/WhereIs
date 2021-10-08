package com.example.whereis.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.whereis.data.local.TrackingDao
import com.example.whereis.data.local.TrackingDatabase
import com.example.whereis.model.TrackingData

class TrackingDataRepository(application: Application) {

    private val trackingDao: TrackingDao
    private val trackingDataList: LiveData<List<TrackingData>>

    init {
        trackingDao = TrackingDatabase.getDatabase(application)!!.trackingDao()
        trackingDataList = trackingDao.getAll()
    }

    fun insertData(trackingData: TrackingData){
        trackingDao.insertData((trackingData))
    }

    fun deleteData(trackingNum: String){
        trackingDao.deleteData(trackingNum)
    }

    fun getAllData() : LiveData<List<TrackingData>>{
        return trackingDataList
    }
}