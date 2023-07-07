package com.example.listtasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listtasks.UsersManager
import com.example.listtasks.adapter.ThreeLinesRvAdapter
import com.example.listtasks.adapter.TwoLinesRvAdapter
import com.example.listtasks.databinding.FragmentThreeLinesItemBinding

class ThreeLinesItemFragment : Fragment() {
    private var _binding : FragmentThreeLinesItemBinding? = null
    private val binding get() = _binding!!
    private val users = UsersManager.generateUsers()
    private var recyclerViewAdapter : ThreeLinesRvAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentThreeLinesItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerView()
    }

    private fun setRecyclerView() = with(binding) {
        recyclerViewAdapter = ThreeLinesRvAdapter(users)
        recyclerViewThreeLines.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewThreeLines.setHasFixedSize(true)
        recyclerViewThreeLines.adapter = recyclerViewAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        recyclerViewAdapter = null
    }

}