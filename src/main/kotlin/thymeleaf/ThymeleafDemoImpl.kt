package thymeleaf

import org.springframework.ui.Model
import java.time.Instant
import java.time.LocalDate

class ThymeleafDemoImpl : ThymeleafDemo {

    override fun getGreetings(model: Model): Model {
        val name = "Michiel"
        val localDate = LocalDate.now()

        model.addAttribute("name", name)
        model.addAttribute("date", localDate)

        return model
    }
}