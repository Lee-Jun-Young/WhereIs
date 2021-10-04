package com.example.whereis.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.R
import com.example.whereis.data.remote.api.CompanyApi
import com.example.whereis.data.remote.RetrofitBuilder
import com.example.whereis.databinding.ActivityAddBinding
import com.example.whereis.model.CompanyList
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var aBinding: ActivityAddBinding
    private lateinit var viewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        aBinding.add = this@AddActivity

        loadData()
    }

    fun loadData() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddViewModel::class.java)
        viewModel.getCompany()
        viewModel.getCompany().observe(this, Observer {
            it.forEach { company ->
                val chip = Chip(this@AddActivity)
                chip.text = company.Name
                chip.setChipBackgroundColorResource(R.color.white)
                aBinding.chipGroup.addView(chip)
            }
            Log.d("Response", it.toString())
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
        }
    }

}