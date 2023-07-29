package com.example.goodsapp.ship

import com.example.goodsapp.tunnel.Tunnel
import com.example.goodsapp.viewmodel.HarborViewModel
import com.example.shipstunnelsgoodsapp.ship.Type

class ShipGenerator(private val tunnel: Tunnel, private val shipCount: Int, private val viewModel: HarborViewModel) : Runnable {

    override fun run() {
        var count = 0
        while (count < shipCount) {
            Thread.currentThread().name = "Generator ship"
            count++
            val type = Type.values().random()
            val size = Size.values().random()

            tunnel.add(Ship(
                type = type,
                size = size
            ))

            val info = "$count ships generated."
            viewModel.updateShipInfo(info)

            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }

    }

}

