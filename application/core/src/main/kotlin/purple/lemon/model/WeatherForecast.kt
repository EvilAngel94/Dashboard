package purple.lemon.model

data class WeatherForecast(
        val homeLocation: String? = "",
        val homeTemperature: Double? = 0.0,
        val homeTemperatureFeelsLike: Double? = 0.0,
        val homeWeatherType: String? = "",
        val workLocation: String? = "",
        val workTemperature: Double? = 0.0,
        val workTemperatureFeelsLike: Double? = 0.0,
        val workWeatherType: String? = "",
        val homeWeatherPicture: String? = "",
        val workWeatherPicture: String? = ""
)