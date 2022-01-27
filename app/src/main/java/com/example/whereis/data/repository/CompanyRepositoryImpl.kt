package com.example.whereis.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.whereis.data.remote.RemoteCompanyDataSource
import com.example.whereis.data.remote.RemoteCompanyDataSourceImpl
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.data.remote.api.CompanyApi
import com.example.whereis.model.Company
import com.example.whereis.model.CompanyList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CompanyRepositoryImpl : CompanyRepository {

    private val remoteCompanyDataSource = RemoteCompanyDataSourceImpl()

    override fun getCompany(): LiveData<List<Company>> = remoteCompanyDataSource.getCompany()

}