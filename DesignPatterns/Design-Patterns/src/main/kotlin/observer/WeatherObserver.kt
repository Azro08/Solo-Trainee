package observer

import java.util.*

interface WeatherObserver {
    fun update(weather: Int)
}

object WeatherObservable {
    private val observers: MutableList<WeatherObserver> = mutableListOf()

    fun addObserver(observer: WeatherObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: WeatherObserver) {
        observers.remove(observer)
    }

    fun notifyObservers(weather: Int) {
        for (observer in observers) {
            observer.update(weather)
        }
    }
}

object WeatherObserverImpl : WeatherObserver {
    override fun update(weather: Int) {
        println("Weather changed: $weather C")
    }
}

object WeatherProvider {
    private var weather: Int = 0

    init {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                weather = calculateWeather()
                WeatherObservable.notifyObservers(weather)
            }
        }, 0, 5000) // Update weather every 5 seconds
    }

    private fun calculateWeather(): Int {
        val currentTime = Date().time / 1000
        return currentTime.toInt() % 35
    }

    fun addObserver(observer: WeatherObserver) {
        WeatherObservable.addObserver(observer)
    }

    fun removeObserver(observer: WeatherObserver) {
        WeatherObservable.removeObserver(observer)
    }
}

class Screen1 {
    init {
        println("Screen 1 opened")
        WeatherProvider.addObserver(WeatherObserverImpl)
    }

    fun close() {
        println("Screen 1 closed")
        WeatherProvider.removeObserver(WeatherObserverImpl)
    }
}

class Screen2 {
    init {
        println("Screen 2 opened")
        WeatherProvider.addObserver(WeatherObserverImpl)
    }

    fun close() {
        println("Screen 2 closed")
        WeatherProvider.removeObserver(WeatherObserverImpl)
    }
}

class Screen3 {
    init {
        println("Screen 3 opened")
        WeatherProvider.addObserver(WeatherObserverImpl)
    }

    fun close() {
        println("Screen 3 closed")
        WeatherProvider.removeObserver(WeatherObserverImpl)
    }
}

fun main() {
    val screen1 = Screen1()
    Thread.sleep(15000)
    screen1.close()

    val screen2 = Screen2()
    Thread.sleep(15000)
    screen2.close()

    val screen3 = Screen3()
    Thread.sleep(15000)
    screen3.close()
}
