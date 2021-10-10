package com.example.whereis.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.whereis.databinding.ItemRvDetailBinding
import com.example.whereis.model.TrackingDetail

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.MainViewHolder>() {

    private val items = ArrayList<TrackingDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding =
            ItemRvDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(trackingDetail: List<TrackingDetail>){
        val diffResult = DiffUtil.calculateDiff(ContentDiffUtil(items, trackingDetail), false)
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(trackingDetail)
    }

    inner class MainViewHolder(private val binding: ItemRvDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(trackingDetail: TrackingDetail) {
            binding.detailData = trackingDetail
        }
    }

    class ContentDiffUtil(private val oldList: List<TrackingDetail>, private val currentList: List<TrackingDetail>) : DiffUtil.Callback() {
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == currentList[newItemPosition]
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == currentList[newItemPosition]
        }

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = currentList.size
    }
}