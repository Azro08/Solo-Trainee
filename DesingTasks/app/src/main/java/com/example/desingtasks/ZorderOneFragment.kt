package com.example.desingtasks

import android.hardware.display.DisplayManager
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.window.layout.WindowMetricsCalculator
import com.example.desingtasks.databinding.ZOrderRelativeSizesBinding

class ZorderOneFragment : Fragment() {
    private var _binding : ZOrderRelativeSizesBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ZOrderRelativeSizesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val windowMetrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(requireActivity())
        val currentBounds = windowMetrics.bounds
        val screenHeight = currentBounds.height()

        // Calculate heights as a percentage of the screen height
        val yellowHeight = (screenHeight * 0.5f).toInt()
        val redHeight = (screenHeight * 0.85f).toInt()
        val blueHeight = (screenHeight * 0.8f).toInt()

        // Set calculated heights to the views
        setViewHeight(binding.yellowView, yellowHeight)
        setViewHeight(binding.redView, redHeight)
        setViewHeight(binding.blueView, blueHeight)
    }



    private fun setViewHeight(view: View, height: Int) {
        val layoutParams = view.layoutParams
        layoutParams.height = height
        view.layoutParams = layoutParams
    }

}