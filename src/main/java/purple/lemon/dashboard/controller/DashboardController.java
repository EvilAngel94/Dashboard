package purple.lemon.dashboard.controller;

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
public class DashboardController {

    @Value("${weather.api.key}")
    private String apiKey;

    private final WeatherForecastInteractable weatherForecastInteractable;

    public DashboardController() {
        weatherForecastInteractable = new WeatherForecastCall();
    }

    @GetMapping("/weather")
    public WeatherForecastModel getWeatherForecast() {
        WeatherForecast weatherForecast = weatherForecastInteractable.getWeatherForecast(CityAndId.Zaamslag.name(), CityAndId.Merelbeke.name(), apiKey);
        return determinePathToPictureToDisplay(weatherForecast);
    }

    private WeatherForecastModel determinePathToPictureToDisplay(WeatherForecast weatherForecast) {
        WeatherForecastModel model = new WeatherForecastModel(weatherForecast);

        return model;
    }

}
