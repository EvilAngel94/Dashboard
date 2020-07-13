package purple.lemon.dashboard.controller.rest;

import interactable.WeatherForecastInteractable;
import interactable.weather.CityAndId;
import interactable.weather.WeatherForecast;
import interactable.weather.WeatherForecastCall;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purple.lemon.dashboard.model.WeatherForecastModel;

@RestController
@RequestMapping("/rest")
public class ButtonController {

    private static final String BASE_LOCATION_IMAGE = "/image/weather/";
    private static final String SUFFIX = ".png";

    @Value("${weather.api.key}")
    private String apiKey;

    private final WeatherForecastInteractable weatherForecastInteractable;

    public ButtonController() {
        this.weatherForecastInteractable = new WeatherForecastCall();
    }

    /**
     * This method retrieves the WeatherForecast information for the Home location and Work location
     * @return Weather forecast model which will be interpret by JS to display
     */
    @GetMapping("/weather")
    public WeatherForecastModel getWeatherForecast() {
        WeatherForecast weatherForecast = weatherForecastInteractable.getWeatherForecast(CityAndId.Zaamslag.name(), CityAndId.Merelbeke.name(), apiKey);
        return setWeatherIconLocation(weatherForecast);
    }

    private WeatherForecastModel setWeatherIconLocation(WeatherForecast weatherForecast) {
        WeatherForecastModel model = new WeatherForecastModel(weatherForecast);

        model.setHomeWeatherPicture(determineWeatherIconLocation(weatherForecast.getHomeWeatherType()));
        model.setWorkWeatherPicture(determineWeatherIconLocation(weatherForecast.getWorkWeatherType()));

        return model;
    }

    private String determineWeatherIconLocation(String weatherType) {
        if (weatherType == null) {
            return "Could not determine";
        }
        String location;

        switch (weatherType) {
            case "Clear":
                location = BASE_LOCATION_IMAGE + "Sun" + SUFFIX;
                break;

            case "Clouds":
                location = BASE_LOCATION_IMAGE + "Cloud" + SUFFIX;
                break;

            case "Mist":
                location = BASE_LOCATION_IMAGE + "Mist" + SUFFIX;
                break;
            case "Rain":
                location = BASE_LOCATION_IMAGE + "Showers" + SUFFIX;
                break;

            case "Drizzle":
                location = BASE_LOCATION_IMAGE + "Drizzle" + SUFFIX;
                break;

            case "Thunderstorm":
                location = BASE_LOCATION_IMAGE + "Thunderstorm" + SUFFIX;
                break;

            default:
                location = "Could not determine";
                break;
        }
        return location;
    }
}
