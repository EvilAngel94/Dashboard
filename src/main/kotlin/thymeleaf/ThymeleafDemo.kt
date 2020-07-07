package thymeleaf

import org.springframework.ui.Model

/**
 * This interface is only for demo purposes
 */
interface ThymeleafDemo {

    fun getGreetings(model: Model): Model

}