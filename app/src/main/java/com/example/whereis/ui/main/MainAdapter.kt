package com.example.whereis.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whereis.databinding.ItemTrackinginfoBinding
import com.example.whereis.model.TrackingData

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items = ArrayList<TrackingData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding =
            ItemTrackinginfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(trackingData: List<TrackingData>) {
        items.clear()
        items.addAll(trackingData)
    }

    fun getDataAt(position: Int): TrackingData {
        return items.get(position)
    }

    inner class MainViewHolder(val binding: ItemTrackinginfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(trackingData: TrackingData) {
            binding.trackData = trackingData
        }
    }
}