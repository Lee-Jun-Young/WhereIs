package com.example.whereis.data.repository

import androidx.lifecycle.LiveData
import com.example.whereis.model.Company

interface CompanyRepository {

    fun getCompany(): LiveData<List<Company>>

}