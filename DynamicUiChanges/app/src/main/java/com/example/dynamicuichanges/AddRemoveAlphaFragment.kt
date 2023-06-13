package com.example.dynamicuichanges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dynamicuichanges.databinding.FragmentAddRemoveAlphaBinding

class AddRemoveAlphaFragment : Fragment() {
    private var _binding : FragmentAddRemoveAlphaBinding? = null
    private val binding get() = _binding!!
    private var alpha = 1.0f
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRemoveAlphaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAddAlpha.setOnClickListener {
            addAlpha()
        }

        binding.buttonRemoveAlpha.setOnClickListener {
            removeAlpha()
        }
    }

    private fun addAlpha() {
        if (alpha > 0.1f) {
            alpha += 0.1f
            binding.imageViewImageAlpha.animate().alpha(alpha)
        }
    }

    private fun removeAlpha() {
        if (alpha < 1f) {
            alpha -= 0.1f
            binding.imageViewImageAlpha.animate().alpha(alpha)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}