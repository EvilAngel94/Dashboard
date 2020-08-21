package purple.lemon.dashboard.utils;

import interactable.weather.WeatherForecast;
import purple.lemon.dashboard.model.WeatherForecastModel;

public final class WeatherForecastImageUtil {

    private static final String BASE_LOCATION_IMAGE = "/image/weather/";
    private static final String SUFFIX = ".png";

    public static WeatherForecastModel setWeatherIconLocation(WeatherForecast weatherForecast) {
        WeatherForecastModel model = new WeatherForecastModel(weatherForecast);

        model.setHomeWeatherPicture(determineWeatherIconLocation(weatherForecast.getHomeWeatherType()));
        model.setWorkWeatherPicture(determineWeatherIconLocation(weatherForecast.getWorkWeatherType()));

        return model;
    }

    private static String determineWeatherIconLocation(String weatherType) {
        if (weatherType == null) {
            return "Could not determine";
        }
        String location;

        switch (weatherType) {
            case "Clear":
                location = BASE_LOCATION_IMAGE + "Sun" + SUFFIX;
                break;

            case "Clouds":
                location = BASE_LOCATION_IMAGE + "Cloud" + SUFFIX;
                break;

            case "Mist":
                location = BASE_LOCATION_IMAGE + "Mist" + SUFFIX;
                break;

            case "Rain":
                location = BASE_LOCATION_IMAGE + "Showers" + SUFFIX;
                break;

            case "Drizzle":
                location = BASE_LOCATION_IMAGE + "Drizzle" + SUFFIX;
                break;

            case "Thunderstorm":
                location = BASE_LOCATION_IMAGE + "Thunderstorm" + SUFFIX;
                break;

            default:
                location = "Could not determine, invalid weather type is provided. Provided weather type: " + weatherType;
                break;
        }
        return location;
    }
}
