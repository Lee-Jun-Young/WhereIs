package com.example.whereis.ui.add

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.model.Company
import com.example.whereis.model.MyResult
import com.example.whereis.model.TrackingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class AddViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CompanyRepository(application)
    private val trackingRepository = TrackingDataRepository(application)
    private val companies = repository.getCompany()
    private val infoRepository = TrackingInfoRepository(application)

    private val _inserted = MutableLiveData<Boolean>()
    val inserted: LiveData<Boolean> = _inserted

    fun getCompany():LiveData<List<Company>> {
        return companies
    }

    fun insertData(trackingData: TrackingData){
        viewModelScope.launch(Dispatchers.IO) {
            val result = infoRepository.getData(trackingData.company_code, trackingData.trackingNum)
            if (result is MyResult.Success) {
                Log.d("test!!",result.toString())
                trackingRepository.insertData(trackingData)
                _inserted.postValue(true)
            }else{
                _inserted.postValue(false)
            }
        }
    }

}