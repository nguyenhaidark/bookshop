package com.example.bookshop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.dto.BookRequest;
import com.example.bookshop.entity.Book;

public interface BookService {
	List<Book> getBooks(int pageNo, int pageSize, String sortBy, String sortDir);

	Book getBookById(Long id);

	List<Book> getBookByName(String name);

	Book addBook(BookRequest bookRequest, MultipartFile multipartFile) throws Exception;

	Book updateBook(BookRequest bookRequest, MultipartFile multipartFile);

	void deleteBook(Long id);
}
