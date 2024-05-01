package org.acme.services.impl;

import java.util.List;

import org.acme.dto.BookRequest;
import org.acme.models.Book;
import org.acme.repository.BookRepository;
import org.acme.services.BookService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BookServiceImpl implements BookService {
	@Inject
	BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findByID(String id) {
		return bookRepository.findByID(id);
	}

	@Override
	public Book create(BookRequest request) {
		return bookRepository.create(request.toBook());
	}
}
