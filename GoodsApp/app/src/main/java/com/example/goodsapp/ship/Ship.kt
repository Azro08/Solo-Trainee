package com.example.goodsapp.ship

import com.example.shipstunnelsgoodsapp.ship.Type

data class Ship(
    val size : Size,
    val type: Type,
    var count : Int = 0
){
    fun countCheck(): Boolean {
        return count < size.value
    }

    fun add(amount: Int) {
        count += amount
        if (count > size.value) {
            count = size.value
        }
    }
}
