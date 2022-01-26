package com.example.whereis.ui.detail

import android.app.Application
import androidx.lifecycle.*
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingData
import com.example.whereis.model.TrackingInfo
import kotlinx.coroutines.launch

class DetailViewModel(
    private val trackingDataRepository: TrackingDataRepository,
    private val trackingInfoRepository: TrackingInfoRepository
) : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _data = MutableLiveData<TrackingData>()
    val data: LiveData<TrackingData> = _data

    private val _info = MutableLiveData<TrackingInfo>()
    val info: LiveData<TrackingInfo> = _info

    fun loadData(trackingNum: String?) {
        viewModelScope.launch {
            val data = trackingDataRepository.getDetailData(trackingNum)

            val result = trackingInfoRepository.getData(data.company_code, data.trackingNum)
            if (result is MyResult.Success) {
                _info.value = result.data!!
            } else {
                _error.value = (result as MyResult.Error).e.message
                    ?: "예상치 못한 에러가 발생했습니다."
                result.e.printStackTrace()
            }
        }
    }

}