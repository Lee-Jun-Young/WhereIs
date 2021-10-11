package com.example.whereis.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.whereis.data.local.TrackingDao
import com.example.whereis.data.local.TrackingDatabase
import com.example.whereis.model.TrackingData

class TrackingDataRepository(application: Application) {

    private val trackingDao: TrackingDao = TrackingDatabase.getDatabase(application)!!.trackingDao()
    private val trackingDataList: LiveData<List<TrackingData>> = trackingDao.getAll()

    fun insertData(trackingData: TrackingData){
        trackingDao.insertData((trackingData))
    }

    fun deleteData(trackingNum: String){
        trackingDao.deleteData(trackingNum)
    }

    fun getDetailData(trackingNum: String?): LiveData<TrackingData>{
        return trackingDao.getDetailData(trackingNum)
    }

    fun getAllData() : LiveData<List<TrackingData>>{
        return trackingDataList
    }
}