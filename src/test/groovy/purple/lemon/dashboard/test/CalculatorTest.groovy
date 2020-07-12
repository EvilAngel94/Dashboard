package purple.lemon.dashboard.test

import spock.lang.Specification

class CalculatorTest extends Specification {
    def "Sum"() {

        given:
        def numberOne = 10
        def numberTwo = 8
        def calculator = new Calculator()

        when:
        def solution = calculator.sum(numberOne, numberTwo)

        then:
        assert 18 == solution
    }
}
