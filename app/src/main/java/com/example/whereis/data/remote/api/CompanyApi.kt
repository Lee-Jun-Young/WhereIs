package com.example.whereis.data.remote.api

import com.example.whereis.model.CompanyList
import retrofit2.Call
import retrofit2.http.GET


interface CompanyApi {
    @GET("api/v1/companylist?t_key=C3LFxtyLgTnP5CAb7LfLhw")
    fun getGithubInfo(): Call<CompanyList>

}