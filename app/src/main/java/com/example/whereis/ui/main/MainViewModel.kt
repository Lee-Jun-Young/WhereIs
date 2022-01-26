package com.example.whereis.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingData
import com.example.whereis.model.TrackingInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val trackingDataRepository: TrackingDataRepository,
    private val trackingInfoRepository: TrackingInfoRepository
) : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _data = MutableLiveData<List<TrackingData>>()
    val data: LiveData<List<TrackingData>> = _data

    private val _info = MutableLiveData<TrackingInfo>()
    val info: LiveData<TrackingInfo> = _info

    fun loadData() {
        viewModelScope.launch {
            val datas = trackingDataRepository.getAllData()
            _data.value = datas
            datas.forEach {
                val result = trackingInfoRepository.getData(it.company_code, it.trackingNum)
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

    fun deleteData(trackingNum: String) {
        viewModelScope.launch(Dispatchers.IO) {
            trackingDataRepository.deleteData(trackingNum)
            loadData()
        }
    }
}