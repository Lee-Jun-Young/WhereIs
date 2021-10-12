package com.example.whereis.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.TrackingInfoApi
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingInfo
import com.example.whereis.model.TrackingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.*
import java.util.concurrent.ConcurrentMap

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