package factorymethod

interface Transport {
    fun getCompanyName(): String
    fun getMaxPayload(): Int
    fun getMaxDimensions(): String
}

class WaterTransport(private val companyName: String, private val maxPayload: Int, private val maxDimensions: String, private val waterType: String) : Transport {
    override fun getCompanyName(): String {
        return companyName
    }

    override fun getMaxPayload(): Int {
        return maxPayload
    }

    override fun getMaxDimensions(): String {
        return maxDimensions
    }

    fun getWaterType(): String {
        return waterType
    }
}

class RailwayTransport(private val companyName: String, private val maxPayload: Int, private val maxDimensions: String, private val railSize: String, private val ballast: Boolean) : Transport {
    override fun getCompanyName(): String {
        return companyName
    }

    override fun getMaxPayload(): Int {
        return maxPayload
    }

    override fun getMaxDimensions(): String {
        return maxDimensions
    }

    fun getRailSize(): String {
        return railSize
    }

    fun hasBallast(): Boolean {
        return ballast
    }
}

class AirTransport(private val companyName: String, private val maxPayload: Int, private val maxDimensions: String, private val airType: String, private val transportType: String) : Transport {
    override fun getCompanyName(): String {
        return companyName
    }

    override fun getMaxPayload(): Int {
        return maxPayload
    }

    override fun getMaxDimensions(): String {
        return maxDimensions
    }

    fun getAirType(): String {
        return airType
    }

    fun getTransportType(): String {
        return transportType
    }
}

class RoadTransport(private val companyName: String, private val maxPayload: Int, private val maxDimensions: String) : Transport {
    override fun getCompanyName(): String {
        return companyName
    }

    override fun getMaxPayload(): Int {
        return maxPayload
    }

    override fun getMaxDimensions(): String {
        return maxDimensions
    }
}

interface TransportCreator {
    fun createTransport(): Transport
}

class RailwayTransportCreator : TransportCreator {
    override fun createTransport(): Transport {
        return RailwayTransport("Железная компания России", 2000, "400x400x400", "1520 мм", true)
    }
}

class WaterTransportCreator : TransportCreator {
    override fun createTransport(): Transport {
        return WaterTransport("Водная компания США", 1500, "300x300x300", "Морской")
    }
}

class RoadTransportCreator : TransportCreator {
    override fun createTransport(): Transport {
        return RoadTransport("Автотранспортная компания Беларуси", 1000, "200x200x200")
    }
}

class AirTransportCreator : TransportCreator {
    override fun createTransport(): Transport {
        return AirTransport("Авиатранспортная компания Германии", 3000, "500x500x500", "Международные", "Грузовой")
    }
}

fun main() {
    val transportCreator: TransportCreator = RailwayTransportCreator()
    val transportRussia = transportCreator.createTransport() as RailwayTransport
    println("Компания: ${transportRussia.getCompanyName()}")
    println("Максимальная грузоподъемность: ${transportRussia.getMaxPayload()} кг")
    println("Максимальные габариты груза: ${transportRussia.getMaxDimensions()}")
    println("Размер колеи: ${transportRussia.getRailSize()}")
    println("Устройство путей: ${if (transportRussia.hasBallast()) "с балластом" else "без балласта"}")
    println("==========================================")

    val waterTransportCreator: TransportCreator = WaterTransportCreator()
    val transportUSA = waterTransportCreator.createTransport() as WaterTransport
    println("Компания: ${transportUSA.getCompanyName()}")
    println("Максимальная грузоподъемность: ${transportUSA.getMaxPayload()} кг")
    println("Максимальные габариты груза: ${transportUSA.getMaxDimensions()}")
    println("Тип водного транспорта: ${transportUSA.getWaterType()}")
    println("==========================================")

    val roadTransportCreator: TransportCreator = RoadTransportCreator()
    val transportBelarus = roadTransportCreator.createTransport() as RoadTransport
    println("Компания: ${transportBelarus.getCompanyName()}")
    println("Максимальная грузоподъемность: ${transportBelarus.getMaxPayload()} кг")
    println("Максимальные габариты груза: ${transportBelarus.getMaxDimensions()}")
    println("==========================================")

    val airTransportCreator: TransportCreator = AirTransportCreator()
    val transportGermany = airTransportCreator.createTransport() as AirTransport
    println("Компания: ${transportGermany.getCompanyName()}")
    println("Максимальная грузоподъемность: ${transportGermany.getMaxPayload()} кг")
    println("Максимальные габариты груза: ${transportGermany.getMaxDimensions()}")
    println("Тип авиатранспорта: ${transportGermany.getAirType()}")
    println("Тип транспорта: ${transportGermany.getTransportType()}")
}
