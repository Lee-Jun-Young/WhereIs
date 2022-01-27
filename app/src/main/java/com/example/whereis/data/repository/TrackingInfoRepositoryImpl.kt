package com.example.whereis.data.repository

import androidx.lifecycle.LiveData
import com.example.whereis.data.remote.RemoteCompanyDataSourceImpl
import com.example.whereis.data.remote.RemoteTrackingInfoDataSourceImpl
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.TrackingInfoApi
import com.example.whereis.model.Company
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit

class TrackingInfoRepositoryImpl : TrackingInfoRepository {

    private val remoteTrackingInfoDataSource = RemoteTrackingInfoDataSourceImpl()

    override suspend fun getData(t_code: String, t_invoice: String): MyResult<TrackingInfo> =
        remoteTrackingInfoDataSource.getData(t_code, t_invoice)

}