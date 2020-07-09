package purple.lemon.dashboard.controller;

import interactable.WeatherForecastInteractable;
import interactable.weather.CityNameToId;
import interactable.weather.WeatherForecastCall;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DashboardController {

    private final WeatherForecastInteractable weatherForecastInteractable;

    public DashboardController() {
        weatherForecastInteractable = new WeatherForecastCall();
    }

    @GetMapping("/weather")
    public void getWeatherForecast() {
        weatherForecastInteractable.getWeatherForecast(CityNameToId.Zaamslag.name(), CityNameToId.Merelbeke.name());
    }
}
