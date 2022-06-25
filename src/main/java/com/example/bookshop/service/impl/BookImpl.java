package com.example.bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.dto.BookRequest;
import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Category;
import com.example.bookshop.myfunction.GetDateNow;
import com.example.bookshop.myfunction.Upload;
import com.example.bookshop.repository.AuthorRepository;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CategoryRepository;
import com.example.bookshop.repository.PublisherRepository;
import com.example.bookshop.service.BookService;

@Service
public class BookImpl implements BookService {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public List<Book> getBooks(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Book> book = bookRepository.findAll(pageable);
		List<Book> books = new ArrayList<>();
		books = book.getContent();
		return books;
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> getBookByName(String name) {
		return bookRepository.searchBookByName(name);
	}

	@Override
	public Book addBook(BookRequest bookRequest, MultipartFile multipartFile) throws Exception {
		List<String> strCatgorys = bookRequest.getCategories();
		List<Category> categories = new ArrayList<>();
		List<String> strAuthor = bookRequest.getAuthors();
		List<Author> authors = new ArrayList<>();
		for (String item : strCatgorys) {
			categories.add(categoryRepository.findByName(item.toString()));
		}
		for (String item : strAuthor) {
			authors.add(authorRepository.findByName(item.toString()));
		}
		Book book = new Book(bookRequest.getName(), bookRequest.getPrice(), bookRequest.getQuantity(),
				bookRequest.isStatus());
		book.setCategories(categories);
		book.setAuthors(authors);
		book.setPublisher(publisherRepository.findByName(bookRequest.getPublisher()));
		book.setCreatedDate(GetDateNow.getDate());
		book.setUpdatedDate("undefined");
		book.setFileName(Upload.UploadImage(multipartFile));
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(BookRequest bookRequest, MultipartFile multipartFile) {
		Book exBook = bookRepository.findById(bookRequest.getId()).orElse(null);
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		exBook.setUpdatedDate(GetDateNow.getDate());
		if (multipartFile.getOriginalFilename().length() > 2) {
			exBook.setFileName(fileName);
		}
		List<String> strCatgorys = bookRequest.getCategories();
		List<Category> categories = new ArrayList<>();
		List<String> strAuthor = bookRequest.getAuthors();
		List<Author> authors = new ArrayList<>();
		for (String item : strCatgorys) {
			categories.add(categoryRepository.findByName(item.toString()));
		}
		for (String item : strAuthor) {
			authors.add(authorRepository.findByName(item.toString()));
		}
		exBook.setCategories(categories);
		exBook.setAuthors(authors);
		exBook.setPublisher(publisherRepository.findByName(bookRequest.getPublisher()));
		exBook.setName(bookRequest.getName());
		exBook.setPrice(bookRequest.getPrice());
		exBook.setQuantity(bookRequest.getQuantity());
		exBook.setStatus(bookRequest.isStatus());
		exBook.setUpdatedDate(GetDateNow.getDate());
		return bookRepository.save(exBook);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
