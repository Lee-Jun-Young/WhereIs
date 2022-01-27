package com.example.whereis.data.remote

import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface RemoteTrackingInfoDataSource {

    suspend fun getData(t_code: String, t_invoice: String): MyResult<TrackingInfo>

}