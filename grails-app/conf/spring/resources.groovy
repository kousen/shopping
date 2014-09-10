import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.json.JsonRenderer
import s2gx.Product

// Place your Spring DSL code here
beans = {
    productRenderer(JsonRenderer, Product) {
        excludes = ['class']
    }

    productsRenderer(JsonCollectionRenderer, Product) {
        excludes = ['class']
    }
}
