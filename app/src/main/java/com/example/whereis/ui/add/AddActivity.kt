package com.example.whereis.ui.add

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.R
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.databinding.ActivityAddBinding
import com.example.whereis.model.Company
import com.example.whereis.model.TrackingData
import com.example.whereis.ui.MainViewModelFactory
import com.example.whereis.ui.ViewModelFactory
import com.example.whereis.ui.main.MainViewModel
import com.google.android.material.chip.Chip

class AddActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var aBinding: ActivityAddBinding
    private lateinit var viewModel: AddViewModel
    private lateinit var mainViewModel: MainViewModel
    private lateinit var selectCompany: Company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        aBinding.add = this@AddActivity

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(application)
        ).get(MainViewModel::class.java)

        setCompanyChipGroup()
    }

    fun setCompanyChipGroup() {
        val repository = CompanyRepository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddViewModel::class.java)
        viewModel.getCompany().observe(this, Observer {
            it.forEach { company ->
                val chip = Chip(this@AddActivity)
                chip.text = company.Name
                chip.setChipBackgroundColorResource(R.color.white)
                chip.setCheckable(true)
                chip.setOnClickListener {
                    selectCompany = company
                }
                aBinding.chipGroup.addView(chip)
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.btn_addInfo -> {
                val num = aBinding.etTrackingNumber.text.toString()

                val temp = TrackingData(num, selectCompany.Name, selectCompany.Code)
                mainViewModel.insertData(temp)

                finish()
            }
        }
    }

}