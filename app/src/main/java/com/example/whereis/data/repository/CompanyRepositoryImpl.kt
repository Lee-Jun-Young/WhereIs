package com.example.whereis.data.repository

import androidx.lifecycle.LiveData
import com.example.whereis.data.remote.RemoteCompanyDataSourceImpl
import com.example.whereis.model.Company
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(private val remoteCompanyDataSource: RemoteCompanyDataSourceImpl) :
    CompanyRepository {

    override fun getCompany(): LiveData<List<Company>> = remoteCompanyDataSource.getCompany()

}