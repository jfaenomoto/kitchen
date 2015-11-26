class UrlMappings {

	static mappings = {
        "/cook/$recipe" (controller: "cook") {
            action = [GET: "cook"]
        }

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
