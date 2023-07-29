package com.example.goodsapp.dock

import com.example.goodsapp.tunnel.Tunnel
import com.example.goodsapp.viewmodel.HarborViewModel
import com.example.shipstunnelsgoodsapp.ship.Type

class DockLoader(private val tunnel: Tunnel, private val shipType: Type, private val viewModel: HarborViewModel) : Runnable {

    override fun run() {
        while (true) {
            try {
                Thread.currentThread().name = "Loader $shipType"

                // Time to load the goods
                Thread.sleep(500)
                val ship = tunnel.get(shipType)
                if (ship != null) {
                    while (ship.countCheck()) {
                        Thread.sleep(100)
                        ship.add(10)
                        val info = "${ship.count} Loaded ship. ${Thread.currentThread().name}"
                        viewModel.updateGoodsInfo(info)
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

}
