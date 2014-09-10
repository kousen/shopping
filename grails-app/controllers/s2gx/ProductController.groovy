package s2gx

import grails.converters.JSON

class ProductController {
    static scaffold = true

    def json() {
        render Product.list(params) as JSON
    }

    def custom() {
        render(contentType: 'application/json') {
            Product.list().collect { p ->
                [name: p.name, price: p.price]
            }
        }
    }
}
