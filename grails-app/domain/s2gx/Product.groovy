package s2gx

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])
class Product {
    String name
    BigDecimal price

    String toString() { name }

    static constraints = {
        name blank: false
        price min: 0.0
    }
}
