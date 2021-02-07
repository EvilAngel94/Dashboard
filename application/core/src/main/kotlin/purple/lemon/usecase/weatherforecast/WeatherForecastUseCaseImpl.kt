package purple.lemon.usecase.weatherforecast

import purple.lemon.weather.WeatherForecastCallApi

class WeatherForecastUseCaseImpl(
        private val weatherForecastCallApi: WeatherForecastCallApi
) : WeatherForecastUseCase {

    override fun getWeatherForeCast(request: WeatherForecastUseCase.Request): WeatherForecastUseCase.Response {
        val apiRequest = WeatherForecastCallApi.WeatherForecastApiRequest(home = request.home, work = request.work)
        val apiResponse = weatherForecastCallApi.getWeatherForecast(apiRequest)
        return WeatherForecastUseCase.Response(apiResponse.weatherForecast)
    }

}