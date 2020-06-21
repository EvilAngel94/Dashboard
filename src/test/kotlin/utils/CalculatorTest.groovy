package utils

import spock.lang.Specification
import utils.Calculator

class CalculatorTest extends Specification {

    def "Add"(){
        given:
        def calculator = new Calculator()

        when:
        def solution = calculator.add(10, 10)

        then:
        solution == 20
    }

}
