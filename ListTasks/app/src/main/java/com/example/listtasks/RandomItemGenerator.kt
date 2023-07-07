package com.example.listtasks

import android.content.Context
import com.example.listtasks.model.TwoItemsCardItem

object RandomItemGenerator {
    private val text = listOf(
        "MY DOCTOR",
        "MY CAREMANAGER",
        "MY DIAGNOSIS",
        "THERAPY PLAN",
        "REMAINING PILLS",
        "MY ORDERS"
    )
    private val colorIds = listOf(
        R.color.red, R.color.green, R.color.blue,
        R.color.yellow, R.color.orange, R.color.purple,
        R.color.pink, R.color.teal, R.color.indigo,
        R.color.cyan, R.color.brown
    )
    private val iconsId = listOf(
        R.drawable.baseline_favorite,
        R.drawable.baseline_newspaper,
        R.drawable.baseline_place,
        R.drawable.baseline_music_note,
        R.drawable.ic_dashboard_black,
        R.drawable.ic_notifications_black
    )

    fun generateRandomItems(): List<TwoItemsCardItem> {
        val randomItems = mutableListOf<TwoItemsCardItem>()
        for (i in 0 until 20) {
            val randomColor = colorIds.random()
            val randomIcon = iconsId.random()
            val randomText = text.random()
            val randomItem = TwoItemsCardItem(
                text = randomText,
                color = randomColor,
                icon = randomIcon
            )
            randomItems.add(randomItem)
        }
        return randomItems
    }
}
