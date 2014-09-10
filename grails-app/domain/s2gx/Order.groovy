package s2gx

import grails.rest.Resource

import java.text.NumberFormat

@Resource(formats = ['json', 'xml'])
class Order {
    String number

    Date dateCreated
    Date lastUpdated

    static hasMany = [orderLines:OrderLine]
    static belongsTo = [customer:Customer]

    double getPrice() {
        orderLines*.price.sum()
    }

    String toString() {
        NumberFormat nf = NumberFormat.currencyInstance
        "#$number: ${orderLines.size()} lines, total cost ${nf.format(price)}"
    }

    static mapping = {
        table 'orders'
        orderLines fetch: 'join'
    }

    static constraints = {
        number unique: true
    }
}
