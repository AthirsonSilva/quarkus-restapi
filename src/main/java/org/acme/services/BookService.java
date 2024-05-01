package org.acme.services;

import java.util.List;

import org.acme.dto.BookRequest;
import org.acme.models.Book;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface BookService {
	public List<Book> findAll();

	public Book findByID(String id);

	public Book create(BookRequest book);
}
