package purple.lemon.Dashboard

import spock.lang.Specification
import purple.lemon.Dashboard.CalculatorJava

class CalculatorJavaTest extends Specification {

    def "Add Java"(){
        given:
        def calculator = new CalculatorJava()

        when:
        def solution = calculator.add(10, 10)

        then:
        solution == 20
    }
}
