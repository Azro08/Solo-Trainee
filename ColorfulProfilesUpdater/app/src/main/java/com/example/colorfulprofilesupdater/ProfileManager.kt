package com.example.colorfulprofilesupdater


import android.content.Context
import androidx.core.content.ContextCompat
import java.util.Calendar
import kotlin.random.Random

object ProfileManager {
    private val profiles: MutableList<Profile> = ArrayList()

    // Generate random profiles
    fun generateProfiles(context: Context): List<Profile> {
        profiles.clear() // Clear existing profiles
        for (i in 1..10) {
            val profile = Profile(
                name = generateRandomName(),
                image = generateRandomColor(context),
                timePassed = generateTimePassed(),
                likes = generateRandomLikes(),
                views = generateRandomViews(),
                recommendedBy = generateRandomRecommendations(),
                description = generateRandomDescription(),
                playedBy = generateRandomPlayedBy()
            )
            profiles.add(profile)
        }
        return profiles
    }

    private fun generateRandomName(): String {
        val names = listOf(
            "Alice",
            "Bob",
            "Charlie",
            "David",
            "Emma",
            "Frank",
            "Grace",
            "Henry",
            "Ivy",
            "Jack"
        )
        return names.shuffled().first()
    }

    private fun generateRandomColor(context: Context): Int {
        val colorIds = listOf(
            R.color.red, R.color.green, R.color.blue,
            R.color.yellow, R.color.magenta, R.color.cyan,
            R.color.orange, R.color.purple, R.color.pink,
            R.color.lightGreen, R.color.darkGreen, R.color.navy,
            R.color.coral, R.color.teal, R.color.hotPink,
            R.color.maroon, R.color.darkCyan, R.color.darkOrange,
            R.color.slateBlue, R.color.fireBrick
        )
        return ContextCompat.getColor(context, colorIds.shuffled().first())
    }

    private fun generateTimePassed(): String {
        val calendar = Calendar.getInstance()
        val year = Random.nextInt(0, 5)
        val month = Random.nextInt(0, 13)
        val day = Random.nextInt(1, 29)
        calendar.set(year, month, day)
        return when {
            year > 0 -> "$year ${if (year == 1) "year" else "years"} ago"
            month > 0 -> "$month ${if (month == 1) "month" else "months"} ago"
            else -> "$day ${if (day == 1) "day" else "days"} ago"
        }
    }

    private fun generateRandomLikes(): Int {
        return Random.nextInt(0, 1000)
    }

    private fun generateRandomViews(): Int {
        return Random.nextInt(0, 10000)
    }

    private fun generateRandomPlayedBy(): Int {
        return Random.nextInt(0, 10000)
    }

    private fun generateRandomRecommendations(): List<Int> {
        val recommendations = mutableListOf<Int>()
        for (i in 1..3) {
            recommendations.add(Random.nextInt(1, 11))
        }
        return recommendations
    }

    private fun generateRandomDescription(): String {
        val descriptions = listOf(
            "Passionate artist creating vibrant and expressive works.",
            "Capturing the beauty of the world through my artistic vision.",
            "Exploring the intersection of art and emotion.",
            "Pushing the boundaries of creativity with every brushstroke.",
            "Using art as a language to tell stories and evoke emotions.",
            "Expressing my innermost thoughts and feelings through art.",
            "Seeking inspiration from nature to create stunning masterpieces.",
            "Experimenting with different techniques to create unique artworks.",
            "Embracing the power of colors and textures in my artistic journey.",
            "Drawing inspiration from everyday life and turning it into art."
        )
        return descriptions.shuffled().first()
    }
}
