package com.example.whereis.data.remote.api

import com.example.whereis.BuildConfig
import com.example.whereis.model.TrackingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackingInfoApi {

    @GET("api/v1/trackingInfo?t_key=${BuildConfig.t_KEY}")
    suspend fun getTrackingInfo(
        @Query("t_code") t_code: String,
        @Query("t_invoice") t_invoice: String
    ): Response<TrackingResponse>
}