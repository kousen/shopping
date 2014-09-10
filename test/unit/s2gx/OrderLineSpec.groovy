package s2gx

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(OrderLine)
class OrderLineSpec extends Specification {
    OrderLine line
    Product p = new Product(name: 'name', price: 2)

    def setup() {
        mockForConstraintsTests(OrderLine)
        line = new OrderLine(product: p, quantity: 3)
    }

    void "line price is product of quantity and product price"() {
        expect:
        line.price == p.price * line.quantity
    }

    void 'sample line is valid'() {
        expect: line.validate()
    }

    void 'negative quantity is invalid'() {
        when:
        line.quantity = -1

        then:
        !line.validate()
        'min' == line.errors.quantity
    }
}
