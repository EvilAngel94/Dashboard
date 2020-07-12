package purple.lemon.dashboard.model;

import interactable.weather.WeatherForecast;

public class WeatherForecastModel {

    private final WeatherForecast weatherForecast;
    private String homeWeatherPicture;
    private String workWeatherPicture;

    public WeatherForecastModel(WeatherForecast weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    public WeatherForecast getWeatherForecast() {
        return weatherForecast;
    }

    public void setHomeWeatherPicture(String homeWeatherPicture) {
        this.homeWeatherPicture = homeWeatherPicture;
    }

    public void setWorkWeatherPicture(String workWeatherPicture) {
        this.workWeatherPicture = workWeatherPicture;
    }
}
