package com.example.whereis.data.remote

import androidx.lifecycle.LiveData
import com.example.whereis.model.Company

interface RemoteCompanyDataSource {

    fun getCompany(): LiveData<List<Company>>
}