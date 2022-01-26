package com.example.whereis.ui.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.model.Company
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(
    private val companyRepository: CompanyRepository,
    private val trackingDataRepository: TrackingDataRepository,
    private val trackingInfoRepository: TrackingInfoRepository
) : ViewModel() {

    private val companies = companyRepository.getCompany()

    private val _inserted = MutableLiveData<Boolean>()
    val inserted: LiveData<Boolean> = _inserted

    fun getCompany(): LiveData<List<Company>> {
        return companies
    }

    fun insertData(trackingData: TrackingData) {
        viewModelScope.launch(Dispatchers.IO) {
            val result =
                trackingInfoRepository.getData(trackingData.company_code, trackingData.trackingNum)
            if (result is MyResult.Success) {
                Log.d("test!!", result.toString())
                trackingDataRepository.insertData(trackingData)
                _inserted.postValue(true)
            } else {
                _inserted.postValue(false)
            }
        }
    }

}