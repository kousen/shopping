import grails.rest.render.hal.HalJsonCollectionRenderer
import grails.rest.render.hal.HalJsonRenderer
import grails.rest.render.hal.HalXmlCollectionRenderer
import grails.rest.render.hal.HalXmlRenderer
import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.json.JsonRenderer
import org.codehaus.groovy.grails.web.mime.MimeType
import s2gx.Customer
import s2gx.Order
import s2gx.OrderXmlRenderer
import s2gx.Product

// Place your Spring DSL code here
beans = {
    productRenderer(JsonRenderer, Product) {
        excludes = ['class']
    }

    productsRenderer(JsonCollectionRenderer, Product) {
        excludes = ['class']
    }

    halProductXmlRenderer(HalXmlRenderer, Product)
    halProductsXmlRenderer(HalXmlCollectionRenderer, Product)

    halProductJsonRenderer(HalJsonRenderer, Product)
    halProductsRenderer(HalJsonCollectionRenderer, Product) {
        collectionName = 'products'
    }

    orderRenderer(OrderXmlRenderer)
    ordersRenderer(HalJsonCollectionRenderer, Order)

    customersRenderer(HalJsonCollectionRenderer, Customer,
        new MimeType("application/vnd.s2gx.cust+json"))
}
