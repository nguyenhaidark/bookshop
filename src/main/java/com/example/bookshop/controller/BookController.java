package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.dto.BookRequest;
import com.example.bookshop.entity.Book;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.BookImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookImpl bookImpl;

	@GetMapping("/get")
	public List<Book> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return bookImpl.getBooks(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/findById")
	public Book getById(@RequestParam Long id) {
		return bookImpl.getBookById(id);
	}

	@GetMapping("/findByName")
	public List<Book> getByName(@RequestParam String name) {
		return bookImpl.getBookByName(name);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@PostMapping("/add")
	public String addBook(BookRequest bookRequest, @RequestParam MultipartFile file) throws Exception {
		if (file.getContentType().contains("image")) {
			bookImpl.addBook(bookRequest, file);
			return "successfully added new";
		} else {
			return "This file is not an image";
		}
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@PutMapping("/update")
	public Book updateBook(BookRequest bookRequest, @RequestParam MultipartFile file) {
		return bookImpl.updateBook(bookRequest, file);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@DeleteMapping("/delete")
	public void deleteBook(@RequestParam Long id) {
		bookImpl.deleteBook(id);
	}
}
