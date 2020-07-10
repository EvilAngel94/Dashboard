package interactable.weather

/**
 * This Enum is responsible for co-relating a city with their ID. This is based on the WeatherApi data.
 */
enum class CityAndId(val id: Int) {

    Zaamslag(2744122),
    Merelbeke(2791315);

    companion object {
        /**
         * This method searches for the city name, and returns their id.
         * If nothing is found, returns null.
         */
        fun convertCityToId(location: String): String {
            val foundValue = values().find {
                it.name == location
            }
            return foundValue?.id.toString();
        }
    }

}

