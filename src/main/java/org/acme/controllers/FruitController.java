package org.acme.controllers;

import java.util.List;

import org.acme.models.Fruit;
import org.acme.services.FruitService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/fruits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FruitController {

	@Inject
	private FruitService fruitService;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fruit> findAll() {
		return fruitService.findAll();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Fruit create(Fruit request) {
		return fruitService.create(request);
	}
}
