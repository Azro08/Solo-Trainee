package com.example.listtasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listtasks.RandomItemGenerator
import com.example.listtasks.adapter.AsymmetricRvAdapter
import com.example.listtasks.databinding.FragmentAsymmetricItemBinding

class AsymmetricItemFragment : Fragment() {
    private var _binding : FragmentAsymmetricItemBinding? = null
    private val binding get() = _binding!!
    private val items = RandomItemGenerator.generateRandomItems()
    private var recyclerViewAdapter : AsymmetricRvAdapter? = null
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         _binding = FragmentAsymmetricItemBinding.inflate(layoutInflater)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerView()
    }

    private fun setRecyclerView() = with(binding){
        recyclerViewAdapter = AsymmetricRvAdapter(items)
        recyclerViewAsymmetricItems.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewAsymmetricItems.setHasFixedSize(true)
        recyclerViewAsymmetricItems.adapter = recyclerViewAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        recyclerViewAdapter = null
    }

}