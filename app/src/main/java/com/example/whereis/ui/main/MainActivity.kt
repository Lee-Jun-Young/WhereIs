package com.example.whereis.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.whereis.R
import com.example.whereis.databinding.ActivityMainBinding
import com.example.whereis.ui.add.AddActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityMainBinding
    private val mainViewModel :MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.main = this@MainActivity

        initRecyclerview()

        mainViewModel.getAllData().observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    fun initRecyclerview(){
        adapter = MainAdapter()
        mBinding.mainRecyclerview.adapter = adapter
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_moveAddActivity -> {
                startActivity(Intent(this, AddActivity::class.java))
            }
        }
    }

}