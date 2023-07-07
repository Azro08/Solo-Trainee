package com.example.listtasks.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listtasks.R
import com.example.listtasks.RandomItemGenerator
import com.example.listtasks.adapter.AsymmetricRvAdapter
import com.example.listtasks.databinding.FragmentAdvancedListBinding
import com.example.listtasks.model.TwoItemsCardItem

class AdvancedListFragment : Fragment() {
    private var _binding : FragmentAdvancedListBinding? = null
    private val binding get() = _binding!!
    private var recyclerViewAdapter : AsymmetricRvAdapter? = null
    private var items = mutableListOf<TwoItemsCardItem>()
    private val initialDelay = 6000L
    private val refreshDelay = 3000L
    private val handler = Handler(Looper.myLooper()!!)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentAdvancedListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        handler.postDelayed({
            items = RandomItemGenerator.generateRandomItems().toMutableList()
            hideProgressView()
            setMenu()
            setRecyclerViewAdapter()
        }, initialDelay)

        binding.swipeRefreshLayout.setOnRefreshListener {
            showProgressView()
            handler.postDelayed({
                items.clear()
                items.addAll(RandomItemGenerator.generateRandomItems())
                hideProgressView()
                binding.swipeRefreshLayout.isRefreshing = false
                setRecyclerViewAdapter()
            }, refreshDelay)
        }
    }

    private fun setRecyclerViewAdapter() = with(binding){
        recyclerViewAdapter = AsymmetricRvAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun setMenu() {
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.nav_bar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.itemClear -> {
                        items.clear()
                        hideProgressView()
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


    private fun showProgressView() = with(binding) {
        progressView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        emptyView.visibility = View.GONE
    }

    private fun hideProgressView() = with(binding) {
        progressView.visibility = View.GONE
        recyclerView.visibility = if (items.isNotEmpty()) View.VISIBLE else View.GONE
        emptyView.visibility = if (items.isEmpty()) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}