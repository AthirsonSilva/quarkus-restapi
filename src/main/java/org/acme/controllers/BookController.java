package org.acme.controllers;

import java.util.List;

import org.acme.dto.BookRequest;
import org.acme.models.Book;
import org.acme.services.BookService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

	@Inject
	BookService bookService;

	@GET
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@POST
	public Book create(BookRequest request) {
		return bookService.create(request);
	}

	@GET
	@Path("/{id}")
	public Book findByID(String id) {
		return bookService.findByID(id);
	}
}
