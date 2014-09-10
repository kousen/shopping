package s2gx

import grails.rest.Resource

@Resource(formats = ['json','xml'])
class Customer {
    String name
    String toString() { name }

    static hasMany = [orders:Order]

    static constraints = {
        name blank: false
    }
}
