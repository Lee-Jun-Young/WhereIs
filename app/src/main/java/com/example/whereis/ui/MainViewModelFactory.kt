package com.example.whereis.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.ui.add.AddViewModel
import com.example.whereis.ui.main.MainViewModel

class MainViewModelFactory (private val repository: TrackingInfoRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}