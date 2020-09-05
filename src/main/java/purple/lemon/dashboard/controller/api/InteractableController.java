package purple.lemon.dashboard.controller.api;

import interactable.WeatherForecastInteractable;
import interactable.weather.CityAndId;
import interactable.weather.WeatherForecast;
import interactable.weather.WeatherForecastCall;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purple.lemon.dashboard.model.Interactable;
import purple.lemon.dashboard.model.WeatherForecastModel;
import purple.lemon.dashboard.utils.WeatherForecastImageUtil;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
@RequestMapping("/api")
public class InteractableController {

    @Value("${weather.api.key}")
    private String apiKey;

    private final WeatherForecastInteractable weatherForecastInteractable;

    public InteractableController() {
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

    @GetMapping("/interactable")
    public List<Interactable> getAllInteractables(){
        ArrayList<Interactable> interactables = new ArrayList<>();
        interactables.add(new Interactable(1, "../image/button/interactive/todo-interaction-btn.gif", "todoist"));
        interactables.add(new Interactable(2, "./image/button/interactive/sketching-interaction-btn.gif", "sketching"));
        return interactables;
    }

}
