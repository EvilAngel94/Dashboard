package thymeleaf

import org.springframework.ui.Model
import java.time.Instant
import java.time.LocalDate

/**
 * Demo purpose
 */
class ThymeleafDemoImpl : ThymeleafDemo {

    override fun getGreetings(model: Model): Model {
        val name = "Michiel"
        val localDate = LocalDate.now()
        val valueToInsert = "Please insert your notes here"

        model.addAttribute("name", name)
        model.addAttribute("date", localDate)
        model.addAttribute("valueToInsert", valueToInsert)

        return model
    }
}