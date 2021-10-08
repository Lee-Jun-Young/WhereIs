package com.example.whereis.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.TrackingInfoApi
import com.example.whereis.model.TrackingInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TrackingInfoRepository(application: Application) {

    private val retrofit: Retrofit = RetrofitBuilder().getInstance()
    private val api = retrofit.create(TrackingInfoApi::class.java)

    fun getData(t_code: String, t_invoice: String): LiveData<TrackingInfo> {
        val data = MutableLiveData<TrackingInfo>()

        api.getTrackingInfo(t_code, t_invoice).enqueue(object : Callback<TrackingInfo> {
            override fun onResponse(call: Call<TrackingInfo>, response: Response<TrackingInfo>) {
                if (response.isSuccessful) {
                    data.value = response.body()!!
                    Log.d("Response", response.toString())
                }
            }

            override fun onFailure(call: Call<TrackingInfo>, t: Throwable) {
                t.stackTrace
            }
        })
        return data
    }

}