package com.example.whereis.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whereis.data.remote.api.CompanyApi
import com.example.whereis.model.Company
import com.example.whereis.model.CompanyList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteCompanyDataSourceImpl @Inject constructor(private val companyApi: CompanyApi) :
    RemoteCompanyDataSource {

    override fun getCompany(): LiveData<List<Company>> {
        val data = MutableLiveData<List<Company>>()

        companyApi.getGithubInfo().enqueue(object : Callback<CompanyList> {
            override fun onResponse(call: Call<CompanyList>, response: Response<CompanyList>) {
                data.value = response.body()!!.companies
            }

            override fun onFailure(call: Call<CompanyList>, t: Throwable) {
                t.stackTrace
            }
        })
        return data
    }


}