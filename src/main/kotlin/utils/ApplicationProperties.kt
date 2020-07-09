package utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ApplicationProperties {

    @Value("\${weather.api.key}")
    lateinit var weatherApiKey: String
}