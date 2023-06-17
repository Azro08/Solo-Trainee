package com.example.customprogressbar

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customprogressbar.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAnimateProgress.setOnClickListener {
            val randomProgress = Random.nextInt(1, 100)
            animateProgressBar(randomProgress)
        }
    }

    private fun animateProgressBar(targetProgress: Int) = with(binding) {
        val animator = ValueAnimator.ofInt(binding.progressBar.progress, targetProgress)
        animator.addUpdateListener { valueAnimator ->
            val progress = valueAnimator.animatedValue as Int
            progressBar.progress = progress
            textViewProgressValue.text = progress.toString()
        }
        animator.duration = 500
        animator.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}