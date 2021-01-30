package purple.lemon.weather

import com.google.gson.Gson
import okhttp3.Call
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import purple.lemon.model.weatherforecast.CityAndId.Companion.convertCityToId
import purple.lemon.model.weatherforecast.WeatherForecast
import purple.lemon.weather.response.WeatherForecastResponse
import java.util.concurrent.TimeUnit

/**
 * This class is responsible for the external call to the api:
 * example: http://api.openweathermap.org/data/2.5/weather?id={city id}&appid={API key}
 */
class WeatherForeCastCallApiImpl(
        private val apiKey: String
) : WeatherForeCastCallApi {

    private val weatherApiURL = "http://api.openweathermap.org/data/2.5/weather"
    private val gson = Gson()
    private val client = createClient()

    /**
     * Main function to obtain all the weather forecast information.
     */
    override fun getWeatherForecast(weatherForeCastApiRequest: WeatherForeCastCallApi.WeatherForeCastApiRequest): WeatherForeCastCallApi.WeatherForeCastApiResponse {

        val weatherForecastHome = callWeatherForecast(apiKey, weatherForeCastApiRequest.home, true)
        val weatherForecastWork = callWeatherForecast(apiKey, weatherForeCastApiRequest.work, false)

        return WeatherForeCastCallApi.WeatherForeCastApiResponse(
                WeatherForecast(
                        weatherForecastHome.homeLocation,
                        weatherForecastHome.homeTemperature,
                        weatherForecastHome.homeTemperatureFeelsLike,
                        weatherForecastHome.homeWeatherType,
                        weatherForecastWork.workLocation,
                        weatherForecastWork.workTemperature,
                        weatherForecastWork.workTemperatureFeelsLike,
                        weatherForecastWork.workWeatherType
                )
        )
    }

    private fun callWeatherForecast(apiKey: String, location: String, homeLocation: Boolean): WeatherForecast {
        val request = createRequest(apiKey, location)
        val response = client.newCall(request).execute()

        return if (response.isSuccessful) {
            val weatherForecastResponse = gson.fromJson(response.body!!.charStream(), WeatherForecastResponse::class.java)
            convertResponseToWeatherForecast(weatherForecastResponse, homeLocation)
        } else {
            WeatherForecast()
        }
    }

    private fun createRequest(apiKey: String, location: String): Request {
        //httpUrl can not be null, otherwise it won't go to the next part.
        val httpUrl = weatherApiURL.toHttpUrlOrNull()?.newBuilder()!!

        httpUrl.addQueryParameter("id", convertCityToId(location))
        httpUrl.addQueryParameter("appid", apiKey)
        httpUrl.addQueryParameter("units", "metric")

        return Request.Builder().get().url(httpUrl.build()).build()
    }

    private fun convertResponseToWeatherForecast(response: WeatherForecastResponse, homeLocation: Boolean): WeatherForecast {
        return if (homeLocation) {
            WeatherForecast(
                    homeLocation = response.name,
                    homeTemperature = response.main.temp,
                    homeWeatherType = response.weather.main,
                    homeTemperatureFeelsLike = response.main.feels_like,
                    homeWeatherPicture = response.weather.icon
            )
        } else {
            WeatherForecast(
                    workLocation = response.name,
                    workTemperature = response.main.temp,
                    workWeatherType = response.weather.main,
                    workTemperatureFeelsLike = response.main.feels_like,
                    workWeatherPicture = response.weather.icon
            )
        }
    }

    // This method is created to easier test the class. Otherwise it would become a bit too hard.
    private fun createClient(): Call.Factory {
        return OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
    }

}