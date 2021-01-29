package purple.lemon.weather.response

/**
 * Class represent the weather object sent from the API.
 *
 * @param id -
 * @param main -
 * @param description -
 * @param icon -
 */
data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)
