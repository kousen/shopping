package s2gx

import grails.rest.render.AbstractRenderer
import grails.rest.render.RenderContext
import groovy.xml.MarkupBuilder
import org.codehaus.groovy.grails.web.mime.MimeType

class OrderXmlRenderer extends AbstractRenderer<Order> {
    OrderXmlRenderer() {
        super(Order, [MimeType.XML, MimeType.TEXT_XML] as MimeType[])
    }

    @Override
    void render(Order order, RenderContext context) {
        context.contentType = MimeType.XML.name

        def builder = new MarkupBuilder(context.writer)
        builder.order(num: order.number) {
            customer order.customer.name
            order.orderLines.each { orderLine ->
                line {
                    product orderLine.product.name
                    quantity orderLine.quantity
                    price orderLine.price
                }
            }
            total order.price
        }
    }
}
