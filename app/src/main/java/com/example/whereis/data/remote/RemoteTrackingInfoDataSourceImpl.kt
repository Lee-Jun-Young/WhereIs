package com.example.whereis.data.remote

import com.example.whereis.data.remote.api.TrackingInfoApi
import com.example.whereis.model.MyResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit

class RemoteTrackingInfoDataSourceImpl(): RemoteTrackingInfoDataSource {

    private val retrofit: Retrofit = RetrofitBuilder().getInstance()
    private val api = retrofit.create(TrackingInfoApi::class.java)

    override suspend fun getData(t_code: String, t_invoice: String) = withContext(Dispatchers.IO) {

        val response = api.getTrackingInfo(t_code, t_invoice)
        return@withContext if (response.isSuccessful) {
            val body = response.body()!!
            if (body.isSuccessful()) {
                MyResult.Success(body.toTrackingInfo())
            } else {
                MyResult.Error(Exception(body.toError().msg))
            }
        } else {
            MyResult.Error(HttpException(response))
        }
    }

}