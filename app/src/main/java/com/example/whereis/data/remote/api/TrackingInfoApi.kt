package com.example.whereis.data.remote.api

import com.example.whereis.model.TrackingInfo
import retrofit2.Call
import retrofit2.http.GET

interface TrackingInfoApi {
    @GET("api/v1/trackingInfo?t_key=C3LFxtyLgTnP5CAb7LfLhw&t_code=04&t_invoice=388589177085")
    fun getTrackingInfo(): Call<TrackingInfo>
}