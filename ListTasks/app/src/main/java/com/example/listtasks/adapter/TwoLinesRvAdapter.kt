package com.example.listtasks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listtasks.model.User
import com.example.listtasks.databinding.TwoLinesItemLayoutBinding

class TwoLinesRvAdapter(private var users: List<User>) :
    RecyclerView.Adapter<TwoLinesRvAdapter.TwoLinesViewHolder>() {

    class TwoLinesViewHolder(
        private var binding: TwoLinesItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var user: User? = null
        fun bind(myUser: User) = with(binding){
            textViewAge.text = myUser.age.toString()
            textViewSex.text = myUser.sex
            val fullName = myUser.firstName + " " + myUser.lastName
            textViewFullName.text = fullName
            user = myUser
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoLinesViewHolder {
        return TwoLinesViewHolder(
            TwoLinesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: TwoLinesViewHolder, position: Int) {
        holder.bind(users[position])
    }

}