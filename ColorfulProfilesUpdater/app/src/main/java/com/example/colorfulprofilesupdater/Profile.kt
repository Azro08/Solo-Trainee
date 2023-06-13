package com.example.colorfulprofilesupdater

data class Profile(
    val name : String,
    val image : Int,
    val timePassed : String,
    var likes : Int,
    var views : Int,
    var playedBy : Int,
    val recommendedBy : List<Int>,
    val description : String
)
