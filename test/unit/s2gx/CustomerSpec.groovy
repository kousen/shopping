package s2gx

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Customer)
class CustomerSpec extends Specification {
    Customer c = new Customer(name: 'name')

    def setup() {
        mockForConstraintsTests(Customer)
    }

    void "sample customer is valid"() {
        expect: c.validate()
    }

    void 'empty name gives blank error'() {
        when:
        c.name = '  '

        then:
        !c.validate()
        'blank' == c.errors['name']
    }
}
