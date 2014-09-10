package s2gx

class Product {
    String name
    BigDecimal price

    String toString() { name }

    static constraints = {
        name blank: false
        price min: 0.0
    }
}
