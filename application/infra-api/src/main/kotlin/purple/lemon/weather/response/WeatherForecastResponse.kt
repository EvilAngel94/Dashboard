package purple.lemon.weather.response

data class WeatherForecastResponse(
        val weather: Weather,
        val main: Main,
        val name: String
)