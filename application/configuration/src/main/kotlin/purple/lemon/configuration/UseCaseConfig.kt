package purple.lemon.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import purple.lemon.infra.jdbc.EditorRepository
import purple.lemon.usecase.editor.EditorUseCase
import purple.lemon.usecase.editor.EditorUseCaseImpl
import purple.lemon.usecase.weatherforecast.WeatherForecastUseCase
import purple.lemon.usecase.weatherforecast.WeatherForecastUseCaseImpl
import purple.lemon.infra.api.WeatherForecastCallApi

@Configuration
open class UseCaseConfig {

    @Bean
    open fun getWeatherForecastUseCase(weatherForecastCallApi: WeatherForecastCallApi): WeatherForecastUseCase {
        return WeatherForecastUseCaseImpl(weatherForecastCallApi)
    }

    @Bean
    open fun getEditorUseCase(editorRepository: EditorRepository): EditorUseCase {
        return EditorUseCaseImpl(editorRepository)
    }
}