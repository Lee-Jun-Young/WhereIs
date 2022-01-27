package com.example.whereis.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.whereis.MyApplication
import com.example.whereis.R
import com.example.whereis.data.repository.*
import com.example.whereis.databinding.ActivityDetailBinding
import com.example.whereis.model.TrackingInfo
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    @Inject
    lateinit var detailViewModel: DetailViewModel
    private lateinit var dBinding: ActivityDetailBinding
    private lateinit var adapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        dBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        dBinding.detail = this@DetailActivity

        detailViewModel.loadData(intent.getStringExtra("itemIdx"))
        initObservers()
    }

    private fun initObservers() {
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