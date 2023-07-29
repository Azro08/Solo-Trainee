package com.example.goodsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.goodsapp.databinding.ActivityMainBinding
import com.example.goodsapp.dock.DockLoader
import com.example.goodsapp.ship.ShipGenerator
import com.example.goodsapp.tunnel.Tunnel
import com.example.goodsapp.viewmodel.HarborViewModel
import com.example.shipstunnelsgoodsapp.ship.Type

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HarborViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create ViewModel using ViewModelProvider
        viewModel = ViewModelProvider(this)[HarborViewModel::class.java]

        // Observe LiveData to update the UI
        viewModel.shipInfo.observe(this) { info ->
            binding.shipInfoTextView.text = info
        }

        viewModel.tunnelInfo.observe(this) { info ->
            binding.tunnelInfoTextView.text = info
        }

        viewModel.goodsInfo.observe(this) { info ->
            binding.goodsInfoTextView.text = info
        }

        // Create the tunnel and start ship generation and pier loaders
        val tunnel = Tunnel(viewModel)
        val shipGenerator = ShipGenerator(tunnel, 10, viewModel)
        Thread(shipGenerator).start()

        for (type in Type.values()) {
            val dockLoader = DockLoader(tunnel, type, viewModel)
            Thread(dockLoader).start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}