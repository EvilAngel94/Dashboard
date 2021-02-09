package purple.lemon.usecase.weatherforecast

import purple.lemon.model.WeatherForecast
import purple.lemon.infra.api.WeatherForecastCallApi

class WeatherForecastUseCaseImpl(
        private val weatherForecastCallApi: WeatherForecastCallApi
) : WeatherForecastUseCase {

    private val baseImageLocation = "image/weather/"
    private val suffix = ".png"

    override fun getWeatherForeCast(request: WeatherForecastUseCase.Request): WeatherForecastUseCase.Response {
        val apiRequest = WeatherForecastCallApi.WeatherForecastApiRequest(home = request.home, work = request.work)
        val apiResponse = weatherForecastCallApi.getWeatherForecast(apiRequest)
        determineTheCorrectWeatherLogo(apiResponse.weatherForecast)

        return WeatherForecastUseCase.Response(apiResponse.weatherForecast)
    }

    private fun determineTheCorrectWeatherLogo(weatherForecast: WeatherForecast) {
        weatherForecast.homeWeatherPicture = determineLogo(weatherForecast.homeWeatherType)
        weatherForecast.workWeatherPicture = determineLogo(weatherForecast.workWeatherType)
    }

    private fun determineLogo(weatherType: String?): String {
        if (weatherType == null) {
            return "Could not determine"
        }

        return when (weatherType) {
            "Clear" -> baseImageLocation + "Sun" + suffix
            "Clouds" -> baseImageLocation + "Cloud" + suffix
            "Mist" -> baseImageLocation + "Mist" + suffix
            "Rain" -> baseImageLocation + "Showers" + suffix
            "Drizzle" -> baseImageLocation + "Drizzle" + suffix
            "Thunderstorm" -> baseImageLocation + "Thunderstorm" + suffix
            else -> "Could not determine, invalid weather type is provided. Provided weather type: $weatherType"
        }
    }

}