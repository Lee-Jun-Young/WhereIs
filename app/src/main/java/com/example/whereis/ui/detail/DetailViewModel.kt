package com.example.whereis.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.model.TrackingData
import com.example.whereis.model.TrackingInfo

class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TrackingDataRepository(application)
    private val infoRepository = TrackingInfoRepository(application)

    fun getTrackingData(companyCode: String, trackingNum: String): LiveData<TrackingInfo> {
        return infoRepository.getData(companyCode, trackingNum)
    }

    fun getDetailData(trackingNum: String?): LiveData<TrackingData> {
        return repository.getDetailData(trackingNum)
    }
}