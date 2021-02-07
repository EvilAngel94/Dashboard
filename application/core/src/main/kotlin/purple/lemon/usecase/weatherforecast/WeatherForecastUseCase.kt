package purple.lemon.usecase.weatherforecast

import purple.lemon.model.WeatherForecast

interface WeatherForecastUseCase {

    fun getWeatherForeCast(request: Request): Response

    data class Request(val home: String, val work: String)

    data class Response(val weatherForecast: WeatherForecast)
}