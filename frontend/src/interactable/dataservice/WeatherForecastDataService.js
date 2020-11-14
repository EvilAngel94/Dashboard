import axios from "axios";

const WEATHER_FORECAST_URL = "http://localhost:1997/api/weather";

class WeatherForecastDataService {
    getWeatherForecast() {
        return axios.get(WEATHER_FORECAST_URL);
    }
}

export default new WeatherForecastDataService();