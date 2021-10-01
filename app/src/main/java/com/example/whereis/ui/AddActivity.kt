package com.example.whereis.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aBinding = DataBindingUtil.setContentView(this, R.layout.activity_add)
        aBinding.add = this@AddActivity

        loadData()
    }

    fun loadData() {
        RetrofitBuilder().getInstance().create(CompanyApi::class.java).getGithubInfo()
            .enqueue(object : Callback<CompanyList> {

                override fun onResponse(call: Call<CompanyList>, response: Response<CompanyList>) {
                    if (response.isSuccessful) {
                        val body: CompanyList? = response.body()
                        Log.d("test!!", body.toString())
                        body?.let {
                            body.companies.forEach { company ->
                                val chip = Chip(this@AddActivity)
                                chip.text = company.Name
                                chip.setChipBackgroundColorResource(R.color.white)
                                aBinding.chipGroup.addView(chip)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<CompanyList>, t: Throwable) {
                    Log.d("test!!", "실패")
                    Log.d("test!!", t.message.toString())
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

}