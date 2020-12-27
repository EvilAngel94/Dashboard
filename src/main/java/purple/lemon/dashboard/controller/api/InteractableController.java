package purple.lemon.dashboard.controller.api;

import interactable.WeatherForecastInteractable;
import interactable.weather.CityAndId;
import interactable.weather.WeatherForecast;
import interactable.weather.WeatherForecastCall;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import purple.lemon.dashboard.model.Interactable;
import purple.lemon.dashboard.model.WeatherForecastModel;
import purple.lemon.dashboard.utils.WeatherForecastImageUtil;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:1994"})
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
     *
     * @return Weather forecast model which will be interpret by JS to display
     */
    @GetMapping("/detail")
    public WeatherForecastModel getWeatherForecast(@RequestParam(value = "detailName") String detailName) {
        if ("weather".equals(detailName)) {
            WeatherForecast weatherForecast = weatherForecastInteractable.getWeatherForecast(CityAndId.Zaamslag.name(), CityAndId.Merelbeke.name(), apiKey);
            return WeatherForecastImageUtil.setWeatherIconLocation(weatherForecast);
        }
        return null;
    }

    @GetMapping("/interactable")
    public List<Interactable> getAllInteractables() {
        ArrayList<Interactable> interactables = new ArrayList<>();
        interactables.add(new Interactable(1, "https://www.todoist.com", "todo-btn.png", "todo-btn.png", "", "interactive/todo-interaction-btn.gif", "Todoist"));
        interactables.add(new Interactable(2, "https://www.autodraw.com/", "sketching-btn.png", "sketching-btn.png", "", "interactive/sketching-interaction-btn.gif", "Sketching"));
        interactables.add(new Interactable(3, "https://www.gmail.com", "pers-mail-btn.png", "pers-mail-btn.png", "", "interactive/pers-mail-interaction-btn.gif", "Personal Mail"));
        interactables.add(new Interactable(4, "https://www.outlook.com", "work-mail-btn.png", "work-mail-btn.png", "", "interactive/work-mail-interaction-btn.gif", "Work Mail"));
        interactables.add(new Interactable(5, "https://drive.google.com/", "google-drive-btn.png", "google-drive-btn.png", "", "interactive/google-drive-interaction-btn.gif", "Google Drive"));
        interactables.add(new Interactable(6, "", "weather-forecast-btn.png", "weather-forecast-btn.png", "weather", "interactive/weather-forecast-interaction-btn.gif", "Weather Forecast"));
        return interactables;
    }

}
