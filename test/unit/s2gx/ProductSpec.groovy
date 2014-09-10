package s2gx

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Product)
class ProductSpec extends Specification {
    Product p = new Product(name: 'p0', price: 1)

    def setup() {
        mockForConstraintsTests(Product)
    }

    void "sample product is valid"() {
        expect: p.validate()
    }

    void 'blank names are invalid'() {
        when:
        p.name = ' '

        then:
        !p.validate()
        'blank' == p.errors['name']
    }

    void 'negative prices are bad'() {
        when:
        p.price = -1

        then:
        !p.validate()
        'min' == p.errors['price']
    }
}
