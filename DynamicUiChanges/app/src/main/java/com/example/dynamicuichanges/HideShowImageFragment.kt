package com.example.dynamicuichanges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dynamicuichanges.databinding.FragmentHideShowImageBinding

class HideShowImageFragment : Fragment() {
    private var _binding : FragmentHideShowImageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHideShowImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonHideImage.setOnClickListener {
            binding.imageViewRandomImage.visibility = View.GONE
            binding.textViewHidden.visibility = View.VISIBLE
        }

        binding.buttonShowImage.setOnClickListener {
            binding.imageViewRandomImage.visibility = View.VISIBLE
            binding.textViewHidden.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}