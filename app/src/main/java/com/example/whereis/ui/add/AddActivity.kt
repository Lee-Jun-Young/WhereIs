package com.example.whereis.ui.add

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.whereis.R
import com.example.whereis.databinding.ActivityAddBinding
import com.example.whereis.extension.NetworkConnection
import com.example.whereis.model.Company
import com.example.whereis.model.TrackingData
import com.google.android.material.chip.Chip

class AddActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var aBinding: ActivityAddBinding
    private val addViewModel: AddViewModel by viewModels()
    private lateinit var selectCompany: Company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        aBinding.add = this@AddActivity

        selectCompany = Company(" ", " ")

        addViewModel.inserted.observe(this) {
            if (it)
                finish()
            else
                Toast.makeText(this, "잘못된 정보입니다. 다시 입력해주세요.", Toast.LENGTH_SHORT).show()
        }

        initEditTextAdd()
        setCompanyChipGroup()
    }

    private fun initEditTextAdd(){
        aBinding.etTrackingNumber.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (NetworkConnection().checkForInternet(this)) {
                    val trackingNum = aBinding.etTrackingNumber.text.toString()
                    if (isEmptyChecked(trackingNum, selectCompany)) {
                        if (trackingNumFormatChecked(trackingNum)) {
                            val temp =
                                TrackingData(trackingNum, selectCompany.Name, selectCompany.Code)
                            addViewModel.insertData(temp)
                        }
                    }
                }else{
                    finish()
                }
            }
            false
        }
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
        }
    }

    private fun isEmptyChecked(num: String, selectCompany: Company): Boolean {
        return when {
            num == "" -> {
                Toast.makeText(this, getString(R.string.add_numToastText), Toast.LENGTH_SHORT)
                    .show()
                false
            }
            selectCompany.Name == " " -> {
                Toast.makeText(
                    this,
                    getString(R.string.add_selectCompanyToastText),
                    Toast.LENGTH_SHORT
                ).show()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun trackingNumFormatChecked(trackingNum: String): Boolean {
        val regex = """^[A-Z0-9_-]{9,22}$""".toRegex()

        return if (!trackingNum.matches(regex)) {
            Toast.makeText(this, getString(R.string.add_checkToastText), Toast.LENGTH_SHORT).show()
            false
        } else
            true
    }

}