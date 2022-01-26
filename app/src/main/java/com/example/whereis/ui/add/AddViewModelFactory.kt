package com.example.whereis.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.CompanyRepositoryImpl
import com.example.whereis.data.repository.TrackingDataRepositoryImpl
import com.example.whereis.data.repository.TrackingInfoRepositoryImpl

class AddViewModelFactory(
    private val companyRepository: CompanyRepositoryImpl,
    private val trackingDataRepository: TrackingDataRepositoryImpl,
    private val trackingInfoRepository: TrackingInfoRepositoryImpl
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