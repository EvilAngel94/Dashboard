package purple.lemon.weather

import purple.lemon.model.weatherforecast.WeatherForecast

interface WeatherForeCastCall {

    fun getWeatherForecast(weatherForeCastRequest: WeatherForeCastRequest): WeatherForecast

    data class WeatherForeCastRequest(
            val home: String,
            val work: String,
            val apiKey: String
    )
}