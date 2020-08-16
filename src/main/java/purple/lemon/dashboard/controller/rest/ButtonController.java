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
import purple.lemon.dashboard.utils.WeatherForecastImageUtil;

@RestController
@RequestMapping("/rest")
public class ButtonController {

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
        return WeatherForecastImageUtil.setWeatherIconLocation(weatherForecast);
    }

}
