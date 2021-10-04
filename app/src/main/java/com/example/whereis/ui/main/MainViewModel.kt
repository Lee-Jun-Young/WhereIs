package com.example.whereis.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.model.Company
import com.example.whereis.model.TrackingInfo

class MainViewModel(private val repository: TrackingInfoRepository) : ViewModel() {

    private val trackingData = repository.getData()

    fun getData(): LiveData<TrackingInfo> {
        return trackingData
    }
}