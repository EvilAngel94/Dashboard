package interactable.weather

enum class CityAndId(val id: Int) {

    Zaamslag(2744122),
    Merelbeke(2791315);

    companion object {
        fun convertLocationToId(location: String): String {
            val foundValue = values().find {
                it.name == location
            }
            return foundValue?.id.toString();
        }
    }

}

