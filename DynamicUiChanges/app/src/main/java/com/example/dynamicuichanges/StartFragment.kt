package com.example.dynamicuichanges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dynamicuichanges.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var _binding : FragmentStartBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAddRemoveView.setOnClickListener{
            findNavController().navigate(R.id.nav_to_add_remove_view_fragment)
        }

        binding.buttonAddRemoveAlpha.setOnClickListener {
            findNavController().navigate(R.id.nav_to_alpha_fragment)
        }

        binding.buttonRandomImage.setOnClickListener {
            findNavController().navigate(R.id.nav_to_hide_show_image_fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}