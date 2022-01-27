package com.example.whereis.data.repository

import com.example.whereis.data.remote.RemoteTrackingInfoDataSourceImpl
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingInfo

class TrackingInfoRepositoryImpl : TrackingInfoRepository {

    private val remoteTrackingInfoDataSource = RemoteTrackingInfoDataSourceImpl()

    override suspend fun getData(t_code: String, t_invoice: String): MyResult<TrackingInfo> =
        remoteTrackingInfoDataSource.getData(t_code, t_invoice)

}