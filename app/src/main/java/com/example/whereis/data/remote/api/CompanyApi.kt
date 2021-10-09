package com.example.whereis.data.remote.api

import com.example.whereis.BuildConfig
import com.example.whereis.model.CompanyList
import retrofit2.Call
import retrofit2.http.GET


interface CompanyApi {
    @GET("api/v1/companylist?t_key=${BuildConfig.t_KEY}")
    fun getGithubInfo(): Call<CompanyList>

}