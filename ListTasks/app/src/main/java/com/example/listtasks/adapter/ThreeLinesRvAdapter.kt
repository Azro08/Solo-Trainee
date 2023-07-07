package com.example.listtasks.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listtasks.model.User
import com.example.listtasks.databinding.ThreeLinesItemBinding

class ThreeLinesRvAdapter(private var users: List<User>) :
    RecyclerView.Adapter<ThreeLinesRvAdapter.ThreeLinesViewHolder>() {

    class ThreeLinesViewHolder(
        private var binding: ThreeLinesItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var user: User? = null
        fun bind(myUser: User) = with(binding){
            val context = itemView.context!!
            textViewAge.text = myUser.age.toString()
            textViewSex.text = myUser.sex
            val fullName = myUser.firstName + " " + myUser.lastName
            textViewName.text = fullName
            textViewDescription.text = myUser.description
            Glide
                .with(context)
                .load(Uri.parse(myUser.avatarUrl))
                .into(imageViewUserAvatar)
            user = myUser
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreeLinesViewHolder {
        return ThreeLinesViewHolder(
            ThreeLinesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ThreeLinesViewHolder, position: Int) {
        holder.bind(users[position])
    }

}