package purple.lemon.weather

import khttp.requests.Request
import khttp.responses.Response
import org.json.JSONObject
import purple.lemon.model.weatherforecast.CityAndId
import purple.lemon.model.weatherforecast.CityAndId.Companion.convertCityToId
import purple.lemon.model.weatherforecast.WeatherForecast

import okhttp3.cal

/**
 * This class is responsible for the external call to the api:
 * example: http://pro.openweathermap.org/data/2.5/forecast/hourly?id={city ID}&appid={your api key}
 */
class WeatherForeCastCallImpl : WeatherForeCastCall {

    private val weatherApiURL = "http://api.openweathermap.org/data/2.5/weather"

    /**
     * Main function to obtain all the weather forecast information.
     */
    override fun getWeatherForecast(weatherForeCastRequest: WeatherForeCastCall.WeatherForeCastRequest): WeatherForecast {
        val apiKey = weatherForeCastRequest.apiKey

        val weatherForecastHome = callWeatherForecast(weatherForeCastRequest.home, apiKey)
        val weatherForecastWork = callWeatherForecast(weatherForeCastRequest.work, apiKey)

        return WeatherForecast(
                weatherForecastHome.homeLocation,
                weatherForecastHome.homeTemperature,
                weatherForecastHome.homeTemperatureFeelsLike,
                weatherForecastHome.homeWeatherType,
                weatherForecastWork.workLocation,
                weatherForecastWork.workTemperature,
                weatherForecastWork.workTemperatureFeelsLike,
                weatherForecastWork.workWeatherType
        )
    }

    private fun callWeatherForecast(location: String, apiKey: String): WeatherForecast {
        val response: Response = httpGet(
                url = weatherApiURL,
                params = createParameters(location, apiKey)
        )

        return if (response.statusCode == 200) {
            createWeatherForecast(location, response.jsonObject)
        } else {
            WeatherForecast()
        }
    }
    

    private fun createParameters(location: String, apiKey: String): Map<String, String> {
        return mapOf(
                "id" to convertCityToId(location),
                "appid" to apiKey,
                "units" to "metric"
        )
    }

    private fun createWeatherForecast(location: String, jsonResponse: JSONObject): WeatherForecast {
        val stringObjects = obtainJsonObjectsInStringFormat(jsonResponse.getJSONArray("weather").getJSONObject(0))
        val temperatures = obtainJsonObjectsInDoubleFormat(jsonResponse.getJSONObject("main"))

        when (location) {
            CityAndId.Zaamslag.name -> {
                return WeatherForecast(
                        location,
                        temperatures[0],
                        temperatures[1],
                        stringObjects[0])
            }
            CityAndId.Merelbeke.name -> {
                return WeatherForecast(
                        "",
                        0.0,
                        0.0,
                        "",
                        location,
                        temperatures[0],
                        temperatures[1],
                        stringObjects[0])
            }
            else -> {
                return WeatherForecast()
            }
        }
    }

    private fun obtainJsonObjectsInDoubleFormat(temperatureObject: JSONObject): List<Double> {
        val temperature = temperatureObject.getDouble("temp")
        val feelsLikeTemperature = temperatureObject.getDouble("feels_like")

        return listOf(temperature, feelsLikeTemperature)
    }

    private fun obtainJsonObjectsInStringFormat(weatherObject: JSONObject): List<String> {
        val weatherType = weatherObject.get("main").toString()
        val weatherDescription = weatherObject.get("description").toString()

        return listOf(weatherType, weatherDescription)
    }
}