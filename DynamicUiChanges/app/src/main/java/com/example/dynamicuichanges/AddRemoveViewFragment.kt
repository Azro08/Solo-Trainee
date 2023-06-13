package com.example.dynamicuichanges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.dynamicuichanges.databinding.FragmentAddRemoveViewBinding

class AddRemoveViewFragment : Fragment() {
    private var _binding : FragmentAddRemoveViewBinding? = null
    private val binding get() = _binding!!
    private var viewCount = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRemoveViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAddView.setOnClickListener {
            addView()
        }

        binding.buttonRemoveView.setOnClickListener {
            removeView()
        }
    }

    private fun addView() {
        val layoutParams = LinearLayout.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.view_width),
            resources.getDimensionPixelSize(R.dimen.view_height)
        )

        layoutParams.setMargins(
            resources.getDimensionPixelSize(R.dimen.view_margin),
            resources.getDimensionPixelSize(R.dimen.view_margin),
            resources.getDimensionPixelSize(R.dimen.view_margin),
            resources.getDimensionPixelSize(R.dimen.view_margin)
        )

        val newView = View(requireContext())
        newView.setBackgroundResource(R.drawable.random_image)
        newView.layoutParams = layoutParams

        binding.linearContainer.addView(newView)
        viewCount++
    }

    private fun removeView() {
        if (viewCount > 0) {
            binding.linearContainer.removeViewAt(viewCount - 1)
            viewCount--
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}