package com.example.listtasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listtasks.RandomItemGenerator
import com.example.listtasks.adapter.TwoItemsRvAdapter
import com.example.listtasks.databinding.FragmentTwoLinesItemBinding

class TwoItemsFragment : Fragment() {
    private var _binding : FragmentTwoLinesItemBinding? = null
    private val binding get() = _binding!!
    private val items = RandomItemGenerator.generateRandomItems()
    private var recyclerViewAdapter : TwoItemsRvAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwoLinesItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    private fun setRecyclerView()= with(binding) {
        recyclerViewAdapter = TwoItemsRvAdapter(items)
        recyclerViewTwoLines.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerViewTwoLines.setHasFixedSize(true)
        recyclerViewTwoLines.adapter = recyclerViewAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        recyclerViewAdapter = null
    }

}
