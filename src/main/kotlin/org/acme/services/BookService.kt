package org.acme.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.acme.dto.CreateBookRequest
import org.acme.models.Book
import org.acme.repository.BookRepository
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

@ApplicationScoped
data class BookService(
    @Inject
    var bookRepository: BookRepository
) {
    private val log = LoggerFactory.getLogger(BookService::class.java)

    fun findAll(): List<Book> {
        log.info("Finding all books")

        return bookRepository.findAll()
    }

    fun findByID(id: String): Book {
        log.info("Finding book: $id")

        return bookRepository.findByID(id)
    }

    fun create(request: CreateBookRequest): Book {
        log.info("Creating book: $request")

        val toCreate = Book(
            id = ObjectId().toHexString(),
            name = request.name,
            description = request.description,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )

        return bookRepository.create(toCreate)
    }
}
