package com.nishant4820.youtubelayout.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nishant4820.youtubelayout.R
import com.nishant4820.youtubelayout.data.*
import com.nishant4820.youtubelayout.databinding.LongVideoItemBinding
import com.nishant4820.youtubelayout.databinding.ShortsTabLayoutBinding

class MainAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataItemList = mutableListOf<DataItem>()

    fun setData(data: List<DataItem>) {
        dataItemList = data.toMutableList()
        notifyDataSetChanged()
    }

    inner class LongVideoItemViewHolder(private val binding: LongVideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindLongVideoView(longVideoItem: LongVideoItem) {
            binding.videoTitle.text = longVideoItem.title
            binding.channelLogo.setImageResource(longVideoItem.channelLogo)
            binding.channelName.text = longVideoItem.channelName
            binding.viewsCount.text = "${longVideoItem.viewsCount} views"
            binding.uploadDate.text = longVideoItem.uploadDate
            binding.thumbnail.setImageResource(longVideoItem.thumbnail)
        }
    }

    inner class ShortsRecyclerViewViewHolder(private val binding: ShortsTabLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.shortsRecyclerView.setHasFixedSize(true)
            binding.shortsRecyclerView.layoutManager =
                LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }

        fun bindShortsRecyclerView(shortsItemList: List<ShortsItem>) {
            val shortsAdapter = ShortsAdapter(shortsItemList)
            binding.shortsRecyclerView.adapter = shortsAdapter
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataItemList[position].viewType) {
            DataItemType.SHORTS ->
                R.layout.shorts_tab_layout
            else -> // DataItemType.LONG_VIDEO
                R.layout.long_video_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.shorts_tab_layout -> {
                val binding = ShortsTabLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ShortsRecyclerViewViewHolder(binding)
            }
            else -> { // R.layout.long_video_item
                val binding =
                    LongVideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LongVideoItemViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LongVideoItemViewHolder -> {
                dataItemList[position].longVideoItem?.let { holder.bindLongVideoView(it) }
            }
            is ShortsRecyclerViewViewHolder -> {
                dataItemList[position].shortsItemList?.let { holder.bindShortsRecyclerView(it) }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }
}