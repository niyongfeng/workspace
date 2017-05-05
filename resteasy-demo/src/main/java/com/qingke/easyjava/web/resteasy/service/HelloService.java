package com.qingke.easyjava.web.resteasy.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloService {
	@GET
	@Produces("application/json")
	public String greeting(@QueryParam("name") String name) {
		return "Hello," + name;
	}
}
