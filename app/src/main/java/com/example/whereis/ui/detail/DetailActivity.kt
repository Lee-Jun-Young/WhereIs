package com.example.whereis.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.whereis.R
import com.example.whereis.databinding.ActivityDetailBinding
import com.example.whereis.model.TrackingInfo

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dBinding: ActivityDetailBinding
    private lateinit var adapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        dBinding.detail = this@DetailActivity

        initView()
    }

    private fun initView(){
        val data =  intent.getSerializableExtra("data") as TrackingInfo
        dBinding.data = data

        val temp = data.trackingDetails

        adapter = DetailAdapter()
        dBinding.detailRecyclerview.adapter = adapter
        adapter.setList(temp)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
        }
    }
}