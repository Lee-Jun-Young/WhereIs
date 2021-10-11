package com.example.whereis.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.whereis.databinding.ItemTrackinginfoBinding
import com.example.whereis.model.TrackingInfo
import com.example.whereis.ui.detail.DetailActivity

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val items = ArrayList<TrackingInfo>()

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

    fun setList(trackingInfo: List<TrackingInfo>){
        val diffResult = DiffUtil.calculateDiff(ContentDiffUtil(items, trackingInfo), false)
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(trackingInfo)
    }

    fun getDataAt(position: Int): String{
        return items[position].invoiceNo
    }

    inner class MainViewHolder(val binding: ItemTrackinginfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(trackingInfo: TrackingInfo) {
            binding.trackData = trackingInfo

            itemView.setOnClickListener {
                Intent(itemView.context, DetailActivity::class.java).apply {
                    putExtra("itemIdx",trackingInfo.invoiceNo)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { itemView.context.startActivity(this) }
            }
        }
    }

    class ContentDiffUtil(private val oldList: List<TrackingInfo>, private val currentList: List<TrackingInfo>) : DiffUtil.Callback() {
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == currentList[newItemPosition]
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].invoiceNo == currentList[newItemPosition].invoiceNo
        }

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = currentList.size
    }
}