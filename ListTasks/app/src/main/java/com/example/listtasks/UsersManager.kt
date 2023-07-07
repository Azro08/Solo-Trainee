package com.example.listtasks

import com.example.listtasks.model.User
import kotlin.random.Random

object UsersManager {
    private val firstNames = listOf("John", "Emma", "Michael", "Sophia", "Daniel", "Olivia", "Alex", "Frank", "Ben")
    private val lastNames = listOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "White")
    private val sexes = listOf("Male", "Female")
    private const val avatarUrls = "https://image.cnbcfm.com/api/v1/image/105773423-1551716977818rtx6p9yw.jpg?v=1551717428&w=700&h=700"
    private val descriptions = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Sed euismod faucibus quam id porttitor.",
        "Praesent consectetur ex vitae neque ullamcorper, in luctus purus dignissim.",
        "Nulla rutrum risus eget ultrices lobortis.",
        "Vestibulum convallis nisi vitae turpis efficitur, a varius lacus efficitur."
    )

    fun generateUsers(): List<User> {
        val users = mutableListOf<User>()
        for (i in 0 until 30) {
            val firstName = firstNames.random()
            val lastName = lastNames.random()
            val age = Random.nextInt(18, 65)
            val sex = sexes.random()
            val avatarUrl = avatarUrls
            val description = descriptions.random()

            val user = User(firstName, lastName, age, sex, avatarUrl, description)
            users.add(user)
        }
        return users
    }
}