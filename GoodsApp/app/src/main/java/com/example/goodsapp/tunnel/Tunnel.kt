package com.example.goodsapp.tunnel

import com.example.goodsapp.viewmodel.HarborViewModel
import com.example.goodsapp.ship.Ship
import com.example.shipstunnelsgoodsapp.ship.Type
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class Tunnel(private val viewModel: HarborViewModel) {
    private val store = mutableListOf<Ship>()
    private val maxShipsInTunnel = 5
    private val minShipsInTunnel = 0
    private var shipsCounter = 0
    private val tunnelLock = ReentrantLock()

    fun add(ship: Ship): Boolean {
        tunnelLock.withLock {
            if (shipsCounter < maxShipsInTunnel) {
                store.add(ship)
                shipsCounter++
                val info =
                    "${store.size} + The ship arrived in the tunnel: ${ship.type} ${ship.size} ${Thread.currentThread().name}"
                viewModel.updateTunnelInfo(info)
            } else {
                val info =
                    "${store.size} > There is no place for a ship in the tunnel: ${Thread.currentThread().name}"
                viewModel.updateTunnelInfo(info)
                return false
            }
        }
        return true
    }

    fun get(shipType: Type): Ship? {
        tunnelLock.withLock {
            var info = ""
            if (shipsCounter > minShipsInTunnel) {
                for (ship in store) {
                    if (ship.type == shipType) {
                        shipsCounter--
                        info =
                            "The ship is taken from tunnel: ${Thread.currentThread().name}"
                        viewModel.updateTunnelInfo(info)
                        store.remove(ship)
                        return ship
                    }
                }
            }
            return null
        }
    }
}
