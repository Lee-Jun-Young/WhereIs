package com.example.whereis.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.ui.add.AddViewModel

class DetailViewModelFactory(
    private val trackingDataRepository: TrackingDataRepository,
    private val trackingInfoRepository: TrackingInfoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModelFactory(trackingDataRepository, trackingInfoRepository) as T
            }
            else -> {
                throw IllegalAccessError()
            }
        }
    }
}