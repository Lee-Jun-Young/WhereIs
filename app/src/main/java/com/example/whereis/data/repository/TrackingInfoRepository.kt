package com.example.whereis.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.CompanyApi
import com.example.whereis.data.remote.api.TrackingInfoApi
import com.example.whereis.model.Company
import com.example.whereis.model.CompanyList
import com.example.whereis.model.TrackingInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TrackingInfoRepository {
    private val retrofit: Retrofit = RetrofitBuilder().getInstance()
    private val api = retrofit.create(TrackingInfoApi::class.java)

    fun getData(): LiveData<TrackingInfo> {
        val data = MutableLiveData<TrackingInfo>()

        api.getTrackingInfo().enqueue(object : Callback<TrackingInfo> {
            override fun onResponse(call: Call<TrackingInfo>, response: Response<TrackingInfo>) {
                data.value=response.body()!!
            }
            override fun onFailure(call: Call<TrackingInfo>, t: Throwable) {
                t.stackTrace
            }
        })
        return data
    }

}