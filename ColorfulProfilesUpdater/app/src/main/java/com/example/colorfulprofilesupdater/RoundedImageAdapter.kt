package com.example.colorfulprofilesupdater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colorfulprofilesupdater.databinding.RecommendedByViewholderBinding

class RoundedImageAdapter(private var profilesList: List<Profile>) :
    RecyclerView.Adapter<RoundedImageAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(private var binding: RecommendedByViewholderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var profile: Profile? = null
        fun bind(myProfile: Profile) {
            binding.imageViewRecommendedByProf.setBackgroundResource(myProfile.image)
            profile = myProfile
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoundedImageAdapter.ProfileViewHolder {
        return ProfileViewHolder(
            RecommendedByViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RoundedImageAdapter.ProfileViewHolder, position: Int) {
        holder.bind(profilesList[position])
    }

    override fun getItemCount(): Int {
        return minOf(profilesList.size, 4)
    }


}