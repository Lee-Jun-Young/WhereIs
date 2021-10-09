package com.example.whereis.ui.add

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.whereis.R
import com.example.whereis.databinding.ActivityAddBinding
import com.example.whereis.model.Company
import com.example.whereis.model.TrackingData
import com.example.whereis.ui.main.MainViewModel
import com.google.android.material.chip.Chip

class AddActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var aBinding: ActivityAddBinding
    private val addViewModel: AddViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var selectCompany: Company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        aBinding.add = this@AddActivity

        selectCompany = Company(" ", " ")

        setCompanyChipGroup()
    }

    private fun setCompanyChipGroup() {
        addViewModel.getCompany().observe(this, Observer {
            it.forEach { company ->
                val chip = Chip(this@AddActivity)
                chip.text = company.Name
                chip.setChipBackgroundColorResource(R.color.white)
                chip.isCheckable = true
                chip.setOnCheckedChangeListener { _, isChecked ->
                    selectCompany = if (isChecked) {
                        Company(company.Code, company.Name)
                    } else {
                        Company(" ", " ")
                    }
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
                val trackingNum = aBinding.etTrackingNumber.text.toString()
                if (isEmptyChecked(trackingNum, selectCompany)) {
                    if (trackingNumFormatChecked(trackingNum)) {
                        val temp = TrackingData(trackingNum, selectCompany.Name, selectCompany.Code)
                        mainViewModel.getTrackingData(temp.company_code, trackingNum)
                            .observe(this, {
                                if (it.result == "Y") {
                                    mainViewModel.insertData(temp)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this,
                                        "입력한 정보가 잘못되었습니다. 다시 입력해 주세요!!",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            })
                    }
                }
            }
        }
    }

    private fun isEmptyChecked(num: String, selectCompany: Company): Boolean {
        return when {
            num == "" -> {
                Toast.makeText(this, "운송장을 입력해 주세요!!", Toast.LENGTH_SHORT).show()
                false
            }
            selectCompany.Name == " " -> {
                Toast.makeText(this, "택배사를 선택해 주세요!!", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun trackingNumFormatChecked(trackingNum: String): Boolean {
        val regex = "^[A-Z0-9_-]{9,22}$".toRegex()

        return if (!trackingNum.matches(regex)) {
            Toast.makeText(this, "운송장 형식을 한번 더 확인해주세요.", Toast.LENGTH_SHORT).show()
            false
        } else
            true
    }
}