package purple.lemon.weather

import purple.lemon.model.weatherforecast.WeatherForecast

interface WeatherForeCastCallApi {

    fun getWeatherForecast(weatherForeCastApiRequest: WeatherForeCastApiRequest): WeatherForeCastApiResponse

    data class WeatherForeCastApiRequest(
            val home: String,
            val work: String
    )

    data class WeatherForeCastApiResponse(
            val weatherForecast: WeatherForecast
    )
}