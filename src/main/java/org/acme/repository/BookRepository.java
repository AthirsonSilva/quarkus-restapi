package org.acme.repository;

import java.util.List;

import org.acme.models.Book;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface BookRepository {
	public Book create(Book book);

	public List<Book> findAll();

	public Book findByID(String id);
}
