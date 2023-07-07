package com.example.listtasks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listtasks.databinding.AsymmetricItemLayoutBinding
import com.example.listtasks.model.TwoItemsCardItem

class AsymmetricRvAdapter(private val itemList: List<TwoItemsCardItem>) :
    RecyclerView.Adapter<AsymmetricRvAdapter.AsymmetricViewHolder>() {

    inner class AsymmetricViewHolder(private var binding: AsymmetricItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myItems: List<TwoItemsCardItem>) = with(binding){
            if (adapterPosition % 2 == 0) mainLinearLayout.layoutDirection = View.LAYOUT_DIRECTION_LTR
            else mainLinearLayout.layoutDirection = View.LAYOUT_DIRECTION_RTL
            when (myItems.size) {
                1 -> {
                    // Only one item in the list
                    leftCardView.apply {
                        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
                        requestLayout()
                    }
                    leftCardView.setBackgroundResource(myItems[0].color)
                    textView1Text.text = myItems[0].text
                    imageView1Icon.setImageResource(myItems[0].icon)

                    // Hide or disable the second and third cards
                    topRightCardView.visibility = View.GONE
                    bottomRightCardView.visibility = View.GONE
                }
                2 -> {
                    // Two items in the list
                    leftCardView.setBackgroundResource(myItems[0].color)
                    textView1Text.text = myItems[0].text
                    imageView1Icon.setImageResource(myItems[0].icon)

                    topRightCardView.apply {
                        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
                        requestLayout()
                    }
                    topRightCardView.setBackgroundResource(myItems[1].color)
                    textView2Text.text = myItems[1].text
                    imageView2Icon.setImageResource(myItems[1].icon)

                    // Hide or disable the third card
                    bottomRightCardView.visibility = View.GONE
                }
                else -> {
                    // Three items in the list
                    leftCardView.setBackgroundResource(myItems[0].color)
                    textView1Text.text = myItems[0].text
                    imageView1Icon.setImageResource(myItems[0].icon)

                    topRightCardView.setBackgroundResource(myItems[1].color)
                    textView2Text.text = myItems[1].text
                    imageView2Icon.setImageResource(myItems[1].icon)

                    bottomRightCardView.setBackgroundResource(myItems[2].color)
                    textView3Text.text = myItems[2].text
                    imageView3Icon.setImageResource(myItems[2].icon)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsymmetricViewHolder {
        val binding = AsymmetricItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AsymmetricViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsymmetricViewHolder, position: Int) {
        val startIndex = position * 3
        val endIndex = minOf(startIndex + 3, itemList.size)
        val items = itemList.subList(startIndex, endIndex)
        holder.bind(items)
    }


    override fun getItemCount(): Int {
        val numItems = itemList.size
        val numRows = numItems / 3
        val remainingItems = numItems % 3
        return if (remainingItems > 0) numRows + 1 else numRows
    }


}
