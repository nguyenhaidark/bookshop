package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.entity.Author;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.AuthorImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	AuthorImpl authorImpl;
	
	@GetMapping("/get")
	public List<Author> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return authorImpl.getAuthors(pageNo, pageSize, sortBy, sortDir);
	}
	
	@GetMapping("/findById")
	public Author getById(@RequestParam Long id) {
		return authorImpl.getAuthorById(id);
	}

	@GetMapping("/findByName")
	public List<Author> getByName(@RequestParam String name) {
		return authorImpl.getAuthorByName(name);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@PostMapping("/add")
	public Author addAuthor(@RequestBody Author author) {
		return authorImpl.addAuthor(author);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@PutMapping("/update")
	public Author updateAuthor(@RequestBody Author author) {
		return authorImpl.updateAuthor(author);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@DeleteMapping("/delete")
	public void deleteAuthor(@RequestParam Long id) {
		authorImpl.deleteAuthor(id);
	}

}
