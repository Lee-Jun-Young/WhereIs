package com.example.whereis.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.ui.add.AddViewModel
import com.example.whereis.ui.main.MainViewModel

class MainViewModelFactory (val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }

}