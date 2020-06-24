package purple.lemon.dashboard

import spock.lang.Specification

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
