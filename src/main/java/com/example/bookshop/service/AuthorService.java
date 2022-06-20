package com.example.bookshop.service;

import java.util.List;


import com.example.bookshop.entity.Author;

public interface AuthorService {
	List<Author> getAuthors(int pageNo, int pageSize, String sortBy, String sortDir);

	Author getAuthorById(Long id);

	List<Author> getAuthorByName(String name);

	Author addAuthor(Author author);

	Author updateAuthor(Author author);

	void deleteAuthor(Long id);
}
