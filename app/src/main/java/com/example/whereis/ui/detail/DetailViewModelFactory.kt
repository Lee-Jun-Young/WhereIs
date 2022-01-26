package com.example.whereis.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.TrackingDataRepositoryImpl
import com.example.whereis.data.repository.TrackingInfoRepositoryImpl

class DetailViewModelFactory(
    private val trackingDataRepository: TrackingDataRepositoryImpl,
    private val trackingInfoRepository: TrackingInfoRepositoryImpl
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