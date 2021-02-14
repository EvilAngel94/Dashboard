package purple.lemon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DashboardApplication {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<DashboardApplication>(*args)
        }
    }
}