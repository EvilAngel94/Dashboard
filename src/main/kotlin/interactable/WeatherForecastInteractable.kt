package interactable

import interactable.weather.WeatherForecast

/**
 * This interface is responsible for obtaining the weatherforecast
 */
interface WeatherForecastInteractable {

    /**
     * Retrieve the weather forecast of the home location and work location
     */
    fun getWeatherForecast(home: String, work: String) : WeatherForecast

}