class UrlMappings {

	static mappings = {
        "/orders"(resources: 'order')
        "/products"(resources: 'product')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
