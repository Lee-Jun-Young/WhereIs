package com.example.whereis.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository

class AddViewModelFactory(
    private val companyRepository: CompanyRepository,
    private val trackingDataRepository: TrackingDataRepository,
    private val trackingInfoRepository: TrackingInfoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {
                AddViewModel(companyRepository, trackingDataRepository, trackingInfoRepository) as T
            }
            else -> {
                throw IllegalAccessError()
            }
        }
    }
}