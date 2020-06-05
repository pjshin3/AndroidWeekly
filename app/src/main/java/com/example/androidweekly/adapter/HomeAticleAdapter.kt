package com.example.androidweekly.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidweekly.databinding.ItemFragmenthomeBinding
import com.example.androidweekly.model.WeeklyAticle

class HomeAticleAdapter : ListAdapter<WeeklyAticle, RecyclerView.ViewHolder>(diffItem()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AticleViewHolder(ItemFragmenthomeBinding.inflate((LayoutInflater.from(parent.context)),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AticleViewHolder){
            holder.bind(getItem(position))
        }
    }

    class AticleViewHolder(private val binding: ItemFragmenthomeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(_item : WeeklyAticle){
            Log.e("philip","아이템 로그 =${_item.hadline}")
            if (_item.imageurl == ""){
                binding.image.visibility = View.GONE
            }
            binding.item = _item
        }
    }

    class diffItem: DiffUtil.ItemCallback<WeeklyAticle>(){
        override fun areItemsTheSame(oldItem: WeeklyAticle, newItem: WeeklyAticle): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: WeeklyAticle, newItem: WeeklyAticle): Boolean =
            oldItem.equals(newItem)
    }
}