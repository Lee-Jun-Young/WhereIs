package com.example.whereis.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.whereis.R
import com.example.whereis.databinding.ActivityMainBinding
import com.example.whereis.model.TrackingInfo
import com.example.whereis.ui.add.AddActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter
    private val datas: MutableList<TrackingInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.main = this@MainActivity

        mainViewModel.loadData()
        initObservers()
        initRecyclerview()

        mBinding.refreshLayout.setOnRefreshListener {
            datas.clear()
            mainViewModel.loadData()
            mBinding.refreshLayout.isRefreshing = false
        }

    }

    private fun initObservers() {
        mainViewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        mainViewModel.info.observe(this) {
            datas.add(it)
            adapter.setList(datas)
        }
    }

    private fun initRecyclerview() {

        val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT /* | ItemTouchHelper.RIGHT */) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition

                    if (direction == ItemTouchHelper.LEFT) {
                        mainViewModel.deleteData(adapter.getDataAt(position))
                    }
                }
            }

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(mBinding.mainRecyclerview)

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