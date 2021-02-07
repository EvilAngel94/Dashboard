package purple.lemon.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import purple.lemon.repository.EditorRepository
import purple.lemon.repository.EditorRepositoryImpl
import purple.lemon.usecase.editor.EditorUseCase
import purple.lemon.usecase.editor.EditorUseCaseImpl
import purple.lemon.usecase.weatherforecast.WeatherForecastUseCase
import purple.lemon.usecase.weatherforecast.WeatherForecastUseCaseImpl
import purple.lemon.weather.WeatherForecastCallApi
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

    @Bean
    open fun getWeatherForecastUseCase(): WeatherForecastUseCase {
        return WeatherForecastUseCaseImpl(getWeatherForeCastCallApi())
    }

    @Bean
    open fun getEditorUseCase(): EditorUseCase {
        return EditorUseCaseImpl(getEditorRepository())
    }

}