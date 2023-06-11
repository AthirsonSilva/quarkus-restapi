package org.acme.resources;

import org.acme.dto.Greeting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class HelloResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public Greeting hello() {
		Greeting greetings = new Greeting("Hello World!");

		return greetings;
	}
}
