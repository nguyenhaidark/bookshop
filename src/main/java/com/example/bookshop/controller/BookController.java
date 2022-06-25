package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.dto.BookRequest;
import com.example.bookshop.entity.Book;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.myfunction.DowloadFile;
import com.example.bookshop.repository.CategoryRepository;
import com.example.bookshop.service.impl.BookImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookImpl bookImpl;
	@Autowired
	CategoryRepository categoryRepository;

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
	
	@GetMapping("/image/{fileName}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName) throws Exception {
		Resource resource = DowloadFile.getFile(fileName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "\"" + fileName + "\"").body(resource);
	}

	@PostMapping("/add")
	public String addBook(BookRequest bookRequest, @RequestParam MultipartFile file) throws Exception {
		if (file.getContentType().contains("image")) {
			bookImpl.addBook(bookRequest, file);
			return "successfully added new";
		} else {
			return "This file is not an image";
		}
	}

	@PutMapping("/update")
	public Book updateBook(BookRequest bookRequest, @RequestParam MultipartFile file) {
		return bookImpl.updateBook(bookRequest, file);
	}

	@DeleteMapping("/delete")
	public void deleteBook(@RequestParam Long id) {
		bookImpl.deleteBook(id);
	}
}