package purple.lemon.infra.api

import purple.lemon.model.WeatherForecast

interface WeatherForecastCallApi {

    fun getWeatherForecast(weatherForecastApiRequest: WeatherForecastApiRequest): WeatherForecastApiResponse

    data class WeatherForecastApiRequest(
            val home: String,
            val work: String
    )

    data class WeatherForecastApiResponse(
            val weatherForecast: WeatherForecast
    )
}