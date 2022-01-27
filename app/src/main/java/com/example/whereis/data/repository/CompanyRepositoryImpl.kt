package com.example.whereis.data.repository

import androidx.lifecycle.LiveData
import com.example.whereis.data.remote.RemoteCompanyDataSourceImpl
import com.example.whereis.model.Company

class CompanyRepositoryImpl : CompanyRepository {

    private val remoteCompanyDataSource = RemoteCompanyDataSourceImpl()

    override fun getCompany(): LiveData<List<Company>> = remoteCompanyDataSource.getCompany()

}