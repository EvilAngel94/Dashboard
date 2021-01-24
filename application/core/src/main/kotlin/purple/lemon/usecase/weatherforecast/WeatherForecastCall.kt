package purple.lemon.usecase.weatherforecast

import purple.lemon.model.weatherforecast.WeatherForecast

interface WeatherForecastCall {

    fun getWeatherForeCast(request: Request): Response

    data class Request(val home: String, val work: String, val apiKey: String)

    class Response(val weatherForecast: WeatherForecast)
}