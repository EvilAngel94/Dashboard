package interactable.weather

//TODO implement this functionality in the WeatherForecast.kt
enum class WeatherType(name: String, pathToIcon: String) {
    CLEAR_SKY("clear sky", ""),
    CLOUDS("Clouds", ""),
    FEW_CLOUDS("few clouds", ""),
    SCATTERED_CLOUDS("scattered clouds", ""),
    BROKEN_CLOUDS("broken clouds", ""),
    SHOWER_RAIN("shower rain", ""),
    RAIN("rain", ""),
    THUNDERSTORM("thunderstorm", ""),
    SNOW("snow", ""),
    MIST("mist", ""),
    EMPTY("", "")
}