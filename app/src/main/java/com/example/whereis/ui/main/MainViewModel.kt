package com.example.whereis.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.model.TrackingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TrackingDataRepository(application)
    private val data = repository.getAllData()

    fun getAllData(): LiveData<List<TrackingData>> {
        return data
    }

    fun insertData(trackingData: TrackingData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(trackingData)
        }
    }

    fun deleteData(trackingData: TrackingData){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteData(trackingData)
        }
    }
}