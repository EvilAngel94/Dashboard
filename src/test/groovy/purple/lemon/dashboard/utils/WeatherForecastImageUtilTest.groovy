package purple.lemon.dashboard.utils

import interactable.weather.WeatherForecast
import spock.lang.Specification

class WeatherForecastImageUtilTest extends Specification {

    def clearWeatherForecast = createWeatherTypeWeatherForecast("Clear")
    def cloudyWeatherForecast = createWeatherTypeWeatherForecast("Clouds")
    def mistWeatherForecast = createWeatherTypeWeatherForecast("Mist")
    def showersWeatherForecast = createWeatherTypeWeatherForecast("Rain")
    def drizzleWeatherForecast = createWeatherTypeWeatherForecast("Drizzle")
    def thunderstormWeatherForecast = createWeatherTypeWeatherForecast("Thunderstorm")
    def invalidWeatherForecast = createWeatherTypeWeatherForecast("")

    def "Get sun image when weather is clear"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(clearWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "image/weather/Sun.png"
        assert result.workWeatherPicture == "image/weather/Sun.png"
    }

    def "Get cloud image when weather is cloudy"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(cloudyWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "image/weather/Cloud.png"
        assert result.workWeatherPicture == "image/weather/Cloud.png"
    }

    def "Get mist image when weather is misty"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(mistWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "image/weather/Mist.png"
        assert result.workWeatherPicture == "image/weather/Mist.png"
    }

    def "Get shower image when weather is terribly rainy"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(showersWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "image/weather/Showers.png"
        assert result.workWeatherPicture == "image/weather/Showers.png"
    }

    def "Get drizzle image when there is just a little bit of rain"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(drizzleWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "image/weather/Drizzle.png"
        assert result.workWeatherPicture == "image/weather/Drizzle.png"
    }

    def "Get thunderstorm image when thunder is going on"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(thunderstormWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "image/weather/Thunderstorm.png"
        assert result.workWeatherPicture == "image/weather/Thunderstorm.png"
    }

    def "Something went wrong while processing, the String should display this"() {
        when:
        def result = WeatherForecastImageUtil.setWeatherIconLocation(invalidWeatherForecast)

        then:
        assert result != null
        assert result.homeWeatherPicture == "Could not determine, invalid weather type is provided. Provided weather type: "
        assert result.workWeatherPicture == "Could not determine, invalid weather type is provided. Provided weather type: "
    }

    private static WeatherForecast createWeatherTypeWeatherForecast(String weatherType) {
        return new WeatherForecast(
                "Zaamslag",
                20.0,
                21.0,
                weatherType,
                "Merelbeke",
                20.0,
                21.0,
                weatherType,
                "",
                ""
        )
    }
}
