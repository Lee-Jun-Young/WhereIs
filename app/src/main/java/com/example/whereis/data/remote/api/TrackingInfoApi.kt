package com.example.whereis.data.remote.api

import com.example.whereis.model.TrackingInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackingInfoApi {

    @GET("api/v1/trackingInfo?t_key=C3LFxtyLgTnP5CAb7LfLhw")
    fun getTrackingInfo(
        @Query("t_code") t_code: String,
        @Query("t_invoice") t_invoice: String
    ): Call<TrackingInfo>

}