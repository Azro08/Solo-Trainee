package facade

class ApiManager {
    fun getData(): String {
        return "Some data"
    }
}

class CacheManager {
    private var cachedData: String? = null

    fun getCachedData(): String? {
        return cachedData
    }

    fun cacheData(data: String) {
        cachedData = data
    }
}

class UserManager {
    private val apiManager: ApiManager = ApiManager()
    private val cacheManager: CacheManager = CacheManager()

    fun getUserData(): String {
        val cachedData = cacheManager.getCachedData()
        return if (cachedData != null) {
            // if data already cached just return it
            cachedData
        } else {
            // if no cached data found we cache it
            val apiData = apiManager.getData()
            cacheManager.cacheData(apiData)
            apiData
        }
    }
}

fun main() {
    val userManager = UserManager()
    val userData = userManager.getUserData()
    println(userData)
}
