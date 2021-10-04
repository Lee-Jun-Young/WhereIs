package com.example.whereis.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.CompanyApi
import com.example.whereis.model.Company
import com.example.whereis.model.CompanyList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    private val retrofit: Retrofit = RetrofitBuilder().getInstance()
    private val api = retrofit.create(CompanyApi::class.java)

    fun getCompany(): LiveData<List<Company>>{
        val data = MutableLiveData<List<Company>>()

        api.getGithubInfo().enqueue(object : Callback<CompanyList> {
            override fun onResponse(call: Call<CompanyList>, response: Response<CompanyList>) {
                data.value=response.body()!!.companies
            }
            override fun onFailure(call: Call<CompanyList>, t: Throwable) {
                t.stackTrace
            }
        })
        return data
    }
}