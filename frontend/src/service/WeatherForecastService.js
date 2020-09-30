import axios from "axios";

const WEATHER_FORECAST_URL = "http://localhost:1997/api/weather";

class WeatherForecastService {
    getWeatherForecast() {
        return axios.get(WEATHER_FORECAST_URL);
    }
}

export default new WeatherForecastService();