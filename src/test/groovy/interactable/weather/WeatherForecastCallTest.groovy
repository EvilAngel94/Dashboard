package interactable.weather


import spock.lang.Specification

/**
 * This test class tests the interactions with the WeatherForecastCall Class.
 * Different flows are tested.
 *  - Happy flow
 *  - Known home location, invalid work location
 *  - invalid home location, known work location
 *  - invalid home location, invalid work location
 */
//TODO create test.properties or something like that
class WeatherForecastCallTest extends Specification {

//    def apiKeyForTesting = '9a70a4b7fbe5e5d1abb947e1809e5d35'
//
//    def "Happy flow of the WeatherForeCastCall"() {
//        given:
//        def weatherForeCastCall = new WeatherForecastCall()
//
//        when:
//        def resultCall = weatherForeCastCall.getWeatherForecast(CityAndId.Zaamslag.name(), CityAndId.Merelbeke.name(), apiKeyForTesting)
//
//        then:
//        assert resultCall.homeLocation == "Zaamslag"
//        assert !resultCall.homeTemperature.naN
//        assert !resultCall.homeTemperatureFeelsLike.naN
//        assert resultCall.homeWeatherType != ""
//        assert resultCall.workLocation == "Merelbeke"
//        assert !resultCall.workTemperature.naN
//        assert !resultCall.workTemperatureFeelsLike.naN
//        assert resultCall.workWeatherType != ""
//    }
//
//    def "Known home city but invalid work city"() {
//        given:
//        def weatherForecastCall = new WeatherForecastCall()
//
//        when:
//        def resultCall = weatherForecastCall.getWeatherForecast(CityAndId.Zaamslag.name(), "Unknown", apiKeyForTesting)
//
//        then:
//        assert resultCall.homeLocation == "Zaamslag"
//        assert !resultCall.homeTemperature.naN
//        assert !resultCall.homeTemperatureFeelsLike.naN
//        assert resultCall.homeWeatherType != ""
//        assert resultCall.workLocation == ""
//        assert resultCall.workTemperature == 0.0
//        assert resultCall.workTemperatureFeelsLike == 0.0
//        assert resultCall.workWeatherType == ""
//    }
//
//    def "Unknown home city but valid work city"() {
//        given:
//        def weatherForecastCall = new WeatherForecastCall()
//
//        when:
//        def resultCall = weatherForecastCall.getWeatherForecast("Unknown", CityAndId.Merelbeke.name(), apiKeyForTesting)
//
//        then:
//        assert resultCall.homeLocation == ""
//        assert resultCall.homeTemperature == 0.0
//        assert resultCall.homeTemperatureFeelsLike == 0.0
//        assert resultCall.homeWeatherType == ""
//        assert resultCall.workLocation == "Merelbeke"
//        assert !resultCall.workTemperature.naN
//        assert !resultCall.workTemperatureFeelsLike.naN
//        assert resultCall.workWeatherType != ""
//    }
//
//    def "Unknown cities for WeatherForecast"() {
//        given:
//        def weatherForecastCall = new WeatherForecastCall()
//
//        when:
//        def resultCall = weatherForecastCall.getWeatherForecast("Unknown", "Unknown", apiKeyForTesting)
//
//        then:
//        assert resultCall.homeLocation == ""
//        assert resultCall.homeTemperature == 0.0
//        assert resultCall.homeTemperatureFeelsLike == 0.0
//        assert resultCall.homeWeatherType == ""
//        assert resultCall.workLocation == ""
//        assert resultCall.workTemperature == 0.0
//        assert resultCall.workTemperatureFeelsLike == 0.0
//        assert resultCall.workWeatherType == ""
//    }
}
