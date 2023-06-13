package builder

fun main() {
    val coffee: Coffee = Coffee.CoffeBuilder()
        .setCoffeeType("latte")
        .addMilk()
        .addSugar()
        .build()

    val coffee2: Coffee = Coffee.CoffeBuilder()
        .addDouble()
        .addSugar()
        .build()

    println(coffee.toString())
    println(coffee2.toString())
}

class Coffee private constructor(
    private val coffeeType: String,
    private val isDouble: Boolean,
    private val hasMilk: Boolean,
    private val hasCream: Boolean,
    private val hasSugar: Boolean,
    private val hasCinnamon: Boolean,
    private val hasSyrup: Boolean
) {
    class CoffeBuilder {
        private var coffeeType: String = "Coffee"
        private var isDouble: Boolean = false
        private var hasMilk: Boolean = false
        private var hasCream: Boolean = false
        private var hasSugar: Boolean = false
        private var hasCinnamon: Boolean = false
        private var hasSyrup: Boolean = false

        fun setCoffeeType(coffeeType: String): CoffeBuilder {
            this.coffeeType = coffeeType
            return this
        }

        fun addDouble(): CoffeBuilder {
            this.isDouble = true
            return this
        }

        fun addMilk(): CoffeBuilder {
            this.hasMilk = true
            return this
        }

        fun addCream(): CoffeBuilder {
            this.hasCream = true
            return this
        }

        fun addSugar(): CoffeBuilder {
            this.hasSugar = true
            return this
        }

        fun addCinnamon(): CoffeBuilder {
            this.hasCinnamon = true
            return this
        }

        fun addSyrup(): CoffeBuilder {
            this.hasSyrup = true
            return this
        }

        fun build(): Coffee {
            return Coffee(
                coffeeType,
                isDouble,
                hasMilk,
                hasCream,
                hasSugar,
                hasCinnamon,
                hasSyrup
            )
        }
    }

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
