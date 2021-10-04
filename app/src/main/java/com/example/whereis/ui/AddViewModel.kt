package com.example.whereis.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.whereis.model.Company

class AddViewModel(private val repository: Repository) : ViewModel() {

    private val companies = repository.getCompany()

    fun getCompany():LiveData<List<Company>> {
        return companies
    }

}