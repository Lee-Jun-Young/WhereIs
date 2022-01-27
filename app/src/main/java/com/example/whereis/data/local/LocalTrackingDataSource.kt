package com.example.whereis.data.local

import com.example.whereis.model.TrackingData

interface LocalTrackingDataSource {

    fun insertData(trackingData: TrackingData)

    fun deleteData(trackingNum: String)

    suspend fun getDetailData(trackingNum: String?): TrackingData

    suspend fun getAllData(): List<TrackingData>

}