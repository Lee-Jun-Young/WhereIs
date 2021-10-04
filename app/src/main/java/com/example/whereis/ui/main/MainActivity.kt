package com.example.whereis.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.R
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.databinding.ActivityMainBinding
import com.example.whereis.ui.MainViewModelFactory
import com.example.whereis.ui.ViewModelFactory
import com.example.whereis.ui.add.AddActivity
import com.example.whereis.ui.add.AddViewModel
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.main = this@MainActivity

        init()
    }

    fun init() {
        val repository = TrackingInfoRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getData().observe(this, Observer {
            Log.d("Response", it.toString())
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_moveAddActivity -> {
                startActivity(Intent(this, AddActivity::class.java))
            }
        }
    }

}