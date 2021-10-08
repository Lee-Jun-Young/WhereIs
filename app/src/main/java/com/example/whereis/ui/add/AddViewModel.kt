package com.example.whereis.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.model.Company

class AddViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CompanyRepository(application)
    private val companies = repository.getCompany()

    fun getCompany():LiveData<List<Company>> {
        return companies
    }

}