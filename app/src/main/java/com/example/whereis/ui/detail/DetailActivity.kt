package com.example.whereis.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.whereis.R
import com.example.whereis.data.repository.CompanyRepository
import com.example.whereis.data.repository.TrackingDataRepository
import com.example.whereis.data.repository.TrackingInfoRepository
import com.example.whereis.databinding.ActivityDetailBinding
import com.example.whereis.model.TrackingInfo
import com.example.whereis.ui.add.AddViewModel
import com.example.whereis.ui.add.AddViewModelFactory

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dBinding: ActivityDetailBinding
    private lateinit var adapter: DetailAdapter
    lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        dBinding.detail = this@DetailActivity

        detailViewModel = ViewModelProvider(this, DetailViewModelFactory(TrackingDataRepository(application), TrackingInfoRepository()))
            .get(DetailViewModel::class.java)

        detailViewModel.loadData(intent.getStringExtra("itemIdx"))
        initObservers()
    }

    private fun initObservers(){
        detailViewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        detailViewModel.info.observe(this) {
            val data = it as TrackingInfo
            val temp = data.trackingDetails

            dBinding.data = data
            adapter = DetailAdapter()
            dBinding.detailRecyclerview.adapter = adapter
            adapter.setList(temp)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
        }
    }

}