package interactable.weather

import spock.lang.Specification

class WeatherForecastCallTest extends Specification {

    def "Happy flow of the WeatherForeCastCall"() {
        given:
        def weatherForeCastCall = new WeatherForecastCall()

        when:
        def successfulCall = weatherForeCastCall.getWeatherForecast(CityNameToId.Zaamslag.name(), CityNameToId.Merelbeke.name())

        then:
        println successfulCall.toString()
    }
}
