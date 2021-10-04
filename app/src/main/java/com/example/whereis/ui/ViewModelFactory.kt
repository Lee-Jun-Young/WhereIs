package com.example.whereis.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.data.repository.Repository
import com.example.whereis.ui.add.AddViewModel

class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddViewModel(repository) as T
    }

}