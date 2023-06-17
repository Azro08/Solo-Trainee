package com.example.compoundview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.compoundview.databinding.CompoundViewLayoutBinding

class ColorSwitcherView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private val colors = arrayOf(
        Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA,
        Color.CYAN, Color.DKGRAY, Color.GRAY, Color.LTGRAY, Color.WHITE
    )
    private var currentIndex = 0

    private val binding: CompoundViewLayoutBinding

    init {
        orientation = VERTICAL

        binding = CompoundViewLayoutBinding.inflate(LayoutInflater.from(context), this)

        binding.previousButton.setOnClickListener { previousColor() }
        binding.nextButton.setOnClickListener { nextColor() }

        updateColor()
    }

    private fun previousColor() {
        currentIndex = (currentIndex - 1 + colors.size) % colors.size
        updateColor()
    }

    private fun nextColor() {
        currentIndex = (currentIndex + 1) % colors.size
        updateColor()
    }

    private fun updateColor() {
        binding.colorView.setBackgroundColor(colors[currentIndex])
        binding.colorValue.text = currentIndex.toString()
    }
}
