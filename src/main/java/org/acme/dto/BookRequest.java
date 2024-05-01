package org.acme.dto;

import org.acme.models.Book;
import org.bson.types.ObjectId;

import java.io.Serializable;

public record BookRequest(
        String name,
        String description
) implements Serializable {

    public Book toBook() {
        var book = new Book();
        book.setId(new ObjectId().toHexString());
        book.setName(name());
        book.setDescription(description());
        return book;
    }

}
