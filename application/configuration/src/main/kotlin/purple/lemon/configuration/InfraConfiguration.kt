package purple.lemon.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import purple.lemon.infra.jdbc.EditorRepository
import purple.lemon.repository.EditorRepositoryImpl
import purple.lemon.infra.api.WeatherForecastCallApi
import purple.lemon.weather.WeatherForecastCallApiImpl

@Configuration
open class InfraConfiguration {

    @Value("\${spring.datasource.url}")
    private val url: String = ""

    @Value("\${spring.datasource.username}")
    private val username: String = ""

    @Value("\${spring.datasource.password}")
    private val password: String = ""

    @Value("\${weather.api.key}")
    private val weatherApiKey: String = ""

    @Bean
    open fun getWeatherForeCastCallApi(): WeatherForecastCallApi {
        return WeatherForecastCallApiImpl(weatherApiKey)
    }

    @Bean
    open fun getEditorRepository(): EditorRepository {
        return EditorRepositoryImpl(
                DataSourceBuilder.create()
                        .url(url)
                        .username(username)
                        .password(password)
                        .build()
        )
    }

}