package purple.lemon.controller

import org.springframework.web.bind.annotation.*
import purple.lemon.model.Interactable
import purple.lemon.model.WeatherForecast
import purple.lemon.usecase.weatherforecast.WeatherForecastUseCase
import java.util.*

@CrossOrigin(origins = ["http://localhost:1994"])
@RestController
@RequestMapping("/api")
class InteractableController(
        private val weatherForecastUseCase: WeatherForecastUseCase
) {

    @GetMapping("/detail")
    fun getWeatherForecast(@RequestParam(value = "detailName") detailName: String): WeatherForecast {
        if ("weather" == detailName) {
            val response = weatherForecastUseCase.getWeatherForeCast(WeatherForecastUseCase.Request("Zaamslag", "Merelbeke"))
            return response.weatherForecast
        }
        return WeatherForecast()
    }

    @GetMapping("/interactable")
    fun getAllInteractables(): List<Interactable> {
        val interactables = ArrayList<Interactable>()
        interactables.add(Interactable(1, "https://www.todoist.com", "todo-btn.png", "todo-btn.png", "", "interactive/todo-interaction-btn.gif", "Todoist"))
        interactables.add(Interactable(2, "https://www.autodraw.com/", "sketching-btn.png", "sketching-btn.png", "", "interactive/sketching-interaction-btn.gif", "Sketching"))
        interactables.add(Interactable(3, "https://www.gmail.com", "pers-mail-btn.png", "pers-mail-btn.png", "", "interactive/pers-mail-interaction-btn.gif", "Personal Mail"))
        interactables.add(Interactable(4, "https://www.outlook.com", "work-mail-btn.png", "work-mail-btn.png", "", "interactive/work-mail-interaction-btn.gif", "Work Mail"))
        interactables.add(Interactable(5, "https://drive.google.com/", "google-drive-btn.png", "google-drive-btn.png", "", "interactive/google-drive-interaction-btn.gif", "Google Drive"))
        interactables.add(Interactable(6, "", "weather-forecast-btn.png", "weather-forecast-btn.png", "weather", "interactive/weather-forecast-interaction-btn.gif", "Weather Forecast"))
        return interactables
    }

}