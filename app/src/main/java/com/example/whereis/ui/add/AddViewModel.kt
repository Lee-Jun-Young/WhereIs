package com.example.whereis.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.model.Company

class AddViewModel(private val repository: CompanyRepository) : ViewModel() {

    private val companies = repository.getCompany()

    fun getCompany():LiveData<List<Company>> {
        return companies
    }

}