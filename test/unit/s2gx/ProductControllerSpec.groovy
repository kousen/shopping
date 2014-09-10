package s2gx

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ProductController)
@Mock(Product)
class ProductControllerSpec extends Specification {

    void setup() {
        Product baseball = new Product(name: 'baseball',
                price: 5.99).save(failOnError: true)
        Product football = new Product(name: 'football',
                price: 12.99).save(failOnError: true)
        Product basketball = new Product(name: 'basketball',
                price: 15.99).save(failOnError: true)
    }

    void "GET returns JSON form of products"() {
        when:
        controller.json()

        then:
        println response.text
        println response.json
        response.json.size() == 3
        response.json.name.sort() ==
            ['baseball', 'basketball', 'football']
        response.json.price.sum() == 5.99 + 12.99 + 15.99
    }

    void "GET with custom render returns products"() {
        when:
        controller.custom()

        then:
        println response.text
        println response.json
        response.json.name.sort() ==
            ['baseball', 'basketball', 'football']
        response.json.price.sum() == 5.99 + 12.99 + 15.99
    }
}
