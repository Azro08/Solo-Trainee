package com.example.listtasks.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listtasks.R
import com.example.listtasks.databinding.ThreeLinesItemBinding
import com.example.listtasks.databinding.TwoItemsLayoutBinding
import com.example.listtasks.model.TwoItemsCardItem
import com.example.listtasks.model.User

class TwoItemsRvAdapter (private val items : List<TwoItemsCardItem>)
    : RecyclerView.Adapter<TwoItemsRvAdapter.TwoItemsViewHolder>() {

    class TwoItemsViewHolder(
        private var binding: TwoItemsLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var item: TwoItemsCardItem? = null
        fun bind(myItem: TwoItemsCardItem) = with(binding){
            textViewTwoItemsText.text = myItem.text
            twoItemsLayout.setBackgroundResource(myItem.color)
            imageViewTwoItemsIcon.setBackgroundResource(myItem.icon)
            item = myItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoItemsViewHolder {
        return TwoItemsViewHolder(
            TwoItemsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TwoItemsViewHolder, position: Int) {
        holder.bind(items[position])
    }

}