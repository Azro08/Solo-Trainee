package com.example.listtasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listtasks.UsersManager
import com.example.listtasks.adapter.TwoLinesRvAdapter
import com.example.listtasks.databinding.FragmentTwoLinesItemBinding

class TwoLinesItemFragment : Fragment() {
    private var _binding : FragmentTwoLinesItemBinding? = null
    private val binding get() = _binding!!
    private val users = UsersManager.generateUsers()
    private var recyclerViewAdapter : TwoLinesRvAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwoLinesItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerView()
    }

    private fun setRecyclerView() = with(binding){
        recyclerViewAdapter = TwoLinesRvAdapter(users)
        recyclerViewTwoLines.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewTwoLines.setHasFixedSize(true)
        recyclerViewTwoLines.adapter = recyclerViewAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        recyclerViewAdapter = null
    }
}