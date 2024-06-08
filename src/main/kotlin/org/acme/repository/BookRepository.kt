package org.acme.repository

import com.mongodb.client.MongoClient
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.acme.models.Book
import org.bson.Document

@ApplicationScoped
data class BookRepository(
    @Inject
    var mongoClient: MongoClient
) {

    fun create(request: Book): Book {
        mongoClient
            .getDatabase(DatabaseConstants.DATABASE_NAME)
            .getCollection(DatabaseConstants.BOOKS_COLLECTION, Book::class.java)
            .insertOne(request)

        return request
    }

    fun findAll(): List<Book> {
        return mongoClient
            .getDatabase(DatabaseConstants.DATABASE_NAME)
            .getCollection(DatabaseConstants.BOOKS_COLLECTION, Book::class.java)
            .find()
            .into(ArrayList())
    }

    fun findByID(id: String): Book {
        val fruit = mongoClient
            .getDatabase(DatabaseConstants.DATABASE_NAME)
            .getCollection(DatabaseConstants.BOOKS_COLLECTION, Book::class.java)
            .find(Document("_id", id))
            .first()

        requireNotNull(fruit) { "Fruit not found" }

        return fruit
    }
}
