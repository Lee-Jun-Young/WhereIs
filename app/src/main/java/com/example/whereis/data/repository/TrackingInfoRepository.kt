package com.example.whereis.data.repository

import android.app.Application
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.TrackingInfoApi
import com.example.whereis.model.MyResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.*

class TrackingInfoRepository(application: Application) {

    private val retrofit: Retrofit = RetrofitBuilder().getInstance()
    private val api = retrofit.create(TrackingInfoApi::class.java)

    suspend fun getData(t_code: String, t_invoice: String) = withContext(Dispatchers.IO){

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