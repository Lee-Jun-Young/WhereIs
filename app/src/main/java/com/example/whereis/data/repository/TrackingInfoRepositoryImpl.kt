package com.example.whereis.data.repository

import com.example.whereis.data.remote.RemoteTrackingInfoDataSourceImpl
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingInfo
import javax.inject.Inject

class TrackingInfoRepositoryImpl @Inject constructor(private val remoteTrackingInfoDataSource: RemoteTrackingInfoDataSourceImpl) :
    TrackingInfoRepository {

    override suspend fun getData(t_code: String, t_invoice: String): MyResult<TrackingInfo> =
        remoteTrackingInfoDataSource.getData(t_code, t_invoice)

}