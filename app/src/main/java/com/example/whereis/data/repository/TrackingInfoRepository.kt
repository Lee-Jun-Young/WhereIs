package com.example.whereis.data.repository

import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingInfo

interface TrackingInfoRepository {

    suspend fun getData(t_code: String, t_invoice: String): MyResult<TrackingInfo>

}