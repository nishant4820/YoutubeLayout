package com.nishant4820.youtubelayout.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nishant4820.youtubelayout.data.ShortsItem
import com.nishant4820.youtubelayout.databinding.ShortsItemBinding

// RecyclerView Adapter for RecyclerView present in shorts_tab_layout
class ShortsAdapter(private val shortsItemList: List<ShortsItem>) :
    RecyclerView.Adapter<ShortsAdapter.ShortsItemViewHolder>() {

    // ViewHolder class for Shorts Video Item
    inner class ShortsItemViewHolder(private val binding: ShortsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindShortsItem(shortsItem: ShortsItem) {
            binding.videoTitle.text = shortsItem.title
            binding.viewsCount.text = "${shortsItem.viewsCount} views"
            binding.thumbnail.setImageResource(shortsItem.thumbnail)
        }
    }

    // Inflating the Layout and creating a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortsItemViewHolder {
        val binding = ShortsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShortsItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shortsItemList.size
    }

    // Binding the ViewHolder Item with it's position's data
    override fun onBindViewHolder(holder: ShortsItemViewHolder, position: Int) {
        holder.bindShortsItem(shortsItemList[position])
    }

}