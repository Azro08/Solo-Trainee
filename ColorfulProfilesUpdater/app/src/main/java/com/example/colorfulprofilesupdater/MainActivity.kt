package com.example.colorfulprofilesupdater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colorfulprofilesupdater.databinding.ActivityMainBinding
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding?=null
    private val binding get() = _binding!!
    private var profileList = listOf<Profile>()
    private var roundedImageAdapter : RoundedImageAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        profileList = ProfileManager.generateProfiles(applicationContext)
        Log.d("prof_size", profileList.size.toString())
        setRecyclerView()
        updateActivity()
    }

    private fun setRecyclerView() {
        roundedImageAdapter = RoundedImageAdapter(profileList)
        binding.recyclerViewRecommended.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewRecommended.setHasFixedSize(true)
        binding.recyclerViewRecommended.adapter = roundedImageAdapter
    }

    private fun updateActivity() {
        val timer = Timer()
        var index = 0
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    binding.apply {
                        textViewDescription.text = profileList[index].description
                        profileImage.setBackgroundColor(profileList[index].image)
                        textViewProfileName.text = profileList[index].name
                        textViewLikes.text = profileList[index].likes.toString()
                        textViewPlayedBy.text = profileList[index].playedBy.toString()
                        textViewViews.text = profileList[index].views.toString()
                        textViewTimeAgo.text = profileList[index].timePassed
                        if (profileList.size>4){
                            viewLeftRecommendations.visibility = View.VISIBLE
                            val leftRecommendationsText = resources.getString(R.string.left_recommendations, profileList.size - 4)
                            viewLeftRecommendations.text = leftRecommendationsText
                        }
                    }
                    index ++
                    if (index == profileList.size) index = 0
                }
            }
        }, 0, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        roundedImageAdapter = null
    }
}