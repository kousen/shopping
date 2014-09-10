package s2gx

import grails.converters.JSON

class CustomerController {
    static scaffold = true

    def json() {
        render Customer.list(params) as JSON
    }

    def custom() {
        render(contentType: 'application/json') {
            Customer.list().collect { c ->
                [name: c.name, numOrders: c.orders.size(),
                    orderNumbers: c.orders*.number
                ]
            }
        }
    }

}
