package purple.lemon.weather.response

/**
 * This class represents the weather information obtained from the Weather API
 */
data class Main(
        val temp: Double,
        val feels_like: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Double,
        val humidity: Double
)