package thymeleaf

import org.springframework.ui.Model

interface ThymeleafDemo {

    fun getGreetings(model: Model): Model

}