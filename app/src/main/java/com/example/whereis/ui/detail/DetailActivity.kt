package com.example.whereis.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.whereis.R
import com.example.whereis.databinding.ActivityDetailBinding
import com.example.whereis.databinding.ActivityMainBinding
import com.example.whereis.model.TrackingInfo
import com.example.whereis.ui.add.AddActivity
import com.example.whereis.ui.main.MainAdapter
import com.example.whereis.ui.main.MainViewModel

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        dBinding.detail = this@DetailActivity
        dBinding.data = intent.getSerializableExtra("data") as TrackingInfo

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
        }
    }
}