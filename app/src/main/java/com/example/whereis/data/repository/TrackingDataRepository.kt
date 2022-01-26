package com.example.whereis.data.repository

import com.example.whereis.model.TrackingData

interface TrackingDataRepository {

    fun insertData(trackingData: TrackingData)

    fun deleteData(trackingNum: String)

    suspend fun getDetailData(trackingNum: String?): TrackingData

    suspend fun getAllData(): List<TrackingData>
}