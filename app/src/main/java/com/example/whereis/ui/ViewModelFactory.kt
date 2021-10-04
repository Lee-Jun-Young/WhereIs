package com.example.whereis.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.ui.add.AddViewModel
import com.example.whereis.ui.main.MainViewModel

class ViewModelFactory(private val repository: CompanyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddViewModel(repository) as T
    }

}