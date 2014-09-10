import s2gx.*

class BootStrap {

    def init = { servletContext ->
        if (!Product.findByName('baseball')) {
            // Make some products
            Product baseball = new Product(name: 'baseball',
                    price: 5.99).save(failOnError: true)
            Product football = new Product(name: 'football',
                    price: 12.99).save(failOnError: true)
            Product basketball = new Product(name: 'basketball',
                    price: 15.99).save(failOnError: true)

            // Make a customer
            Customer cb = new Customer(name: 'Charlie Brown').save(failOnError: true)

            // Add a couple of orders to the customer
            new Order(number: '1', customer: cb)
                    .addToOrderLines(product: baseball, quantity: 2)
                    .addToOrderLines(product: football, quantity: 1)
                    .save(failOnError: true)
            new Order(number: '2', customer: cb)
                    .addToOrderLines(product: basketball, quantity: 1)
                    .save(failOnError: true)
        }
    }

    def destroy = {
    }
}
