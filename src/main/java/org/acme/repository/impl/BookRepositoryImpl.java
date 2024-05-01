package org.acme.repository.impl;

import com.mongodb.client.MongoClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.models.Book;
import org.acme.repository.BookRepository;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static org.acme.repository.DatabaseConstants.BOOKS_COLLECTION;
import static org.acme.repository.DatabaseConstants.DATABASE_NAME;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @Inject
    MongoClient mongoClient;


    @Override
    public Book create(Book request) {
        mongoClient
                .getDatabase(DATABASE_NAME)
                .getCollection(BOOKS_COLLECTION, Book.class)
                .insertOne(request);

        return request;
    }

    @Override
    public List<Book> findAll() {
        return mongoClient
                .getDatabase(DATABASE_NAME)
                .getCollection(BOOKS_COLLECTION, Book.class)
                .find()
                .into(new ArrayList<>());
    }

    @Override
    public Book findByID(String id) {
        var fruit = mongoClient
                .getDatabase(DATABASE_NAME)
                .getCollection(BOOKS_COLLECTION, Book.class)
                .find(new Document("_id", id))
                .first();

        if (fruit == null) {
            throw new IllegalArgumentException("Fruit not found");
        }

        return fruit;
    }

}
