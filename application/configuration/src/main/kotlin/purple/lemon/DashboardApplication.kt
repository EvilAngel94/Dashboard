package purple.lemon

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class DashboardApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(DashboardApplication::class.java, *args)
    }
}