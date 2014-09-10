class UrlMappings {

	static mappings = {
        "/orders"(resources: 'order')

        "/products"(resources: 'product')

        "/customers"(resources: 'customer') {
            '/orders'(resources: 'order')
        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
