package s2gx

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Order)
class OrderSpec extends Specification {
    Order order

    def setup() {
        mockForConstraintsTests(Order)
        Product p0 = new Product(name: 'p0', price: 2.5)
        Product p1 = new Product(name: 'p1', price: 3)
        Customer c = new Customer(name: 'c')

        order = new Order(customer: c, number: 1)
            .addToOrderLines(product: p0, quantity: 2)
            .addToOrderLines(product: p1, quantity: 1)
    }

    void "order price is sum of line prices"() {
        expect:
        order.price == order.orderLines*.price.sum()
    }
}
