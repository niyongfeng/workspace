package com.qingke.easyjava.web.resteasy.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/people")
public class PeopleService {
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String getPeople(@PathParam("id") String id) {
		if("1".equalsIgnoreCase(id)) {
			return "Qingke";
		}else if("2".equalsIgnoreCase(id)) {
			return "Junqiang Tech";
		}else {
			return "N/A";
		}
	}
}
