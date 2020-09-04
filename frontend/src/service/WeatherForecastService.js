import axios from "axios";

const WEATHER_FORECAST_URL = "http://localhost:8080/api/weather";

class WeatherForecastService {
    getWeatherForecast() {
        return axios.get(WEATHER_FORECAST_URL);
    }
}

export default new WeatherForecastService();