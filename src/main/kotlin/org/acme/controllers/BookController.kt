package org.acme.controllers

import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.acme.dto.CreateBookRequest
import org.acme.models.Book
import org.acme.services.BookService

@Path("/api/v1/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
data class BookController(
    @Inject
    var bookService: BookService
) {

    @GET
    fun findAll(): List<Book> {
        return bookService.findAll()
    }

    @POST
    fun create(request: CreateBookRequest): Book {
        return bookService.create(request)
    }

    @GET
    @Path("/{id}")
    fun findByID(id: String): Book {
        return bookService.findByID(id)
    }
}
