package builder

data class Coffee2 (
        private var coffeeType: String = "Coffee",
        var isDouble: Boolean = false,
        var hasMilk: Boolean = false,
        var hasCream: Boolean = false,
        var hasSugar: Boolean = false,
        var hasCinnamon: Boolean = false,
        var hasSyrup: Boolean = false
) {
    override fun toString(): String {
        val components = mutableListOf<String>()
        components.add(coffeeType)
        if (isDouble) components.add("Double Coffee")
        if (hasMilk) components.add("Milk")
        if (hasCream) components.add("Cream")
        if (hasSugar) components.add("Sugar")
        if (hasCinnamon) components.add("Cinnamon")
        if (hasSyrup) components.add("Syrup")
        return components.joinToString(", ")
    }
}

fun main() {
    val coffee = Coffee2(
            hasSugar = true,
            hasMilk = true,
            coffeeType = "Latte"
    )

    val coffee2 = Coffee2(
            isDouble = true,
            hasSugar = true
    )

    println(coffee.toString())
    println(coffee2.toString())
}
