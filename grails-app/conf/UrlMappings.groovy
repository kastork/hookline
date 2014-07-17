class UrlMappings {

	static mappings = {

        "/commithook" (controller: "CommitHook") {
            action = [POST: "processCommit"]
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
