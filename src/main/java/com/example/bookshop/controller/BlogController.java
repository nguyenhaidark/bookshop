package com.example.bookshop.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookshop.entity.Blog;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.BlogImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	BlogImpl blogImpl;

	@GetMapping("/get")
	public List<Blog> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return blogImpl.getBlogs(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/findById")
	public Blog getById(@RequestParam Long id) {
		return blogImpl.getBlogById(id);
	}

	@GetMapping("/findByTitle")
	public List<Blog> getByTile(@RequestParam String title) {
		return blogImpl.getBlogByTitle(title);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@PostMapping("/add")
	public String addBlog(Blog blog, @RequestParam MultipartFile file) throws Exception {
		if (file.getContentType().contains("image")) {
			blogImpl.addBlog(blog, file);
			return "successfully added new";
		} else {
			return "This file is not an image";
		}
	}

	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@PutMapping("/update")
	public Blog updateBlog(Blog blog, @RequestParam MultipartFile file) {
		return blogImpl.updateBlog(blog, file);
	}
	@PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
	@DeleteMapping("/delete")
	public void deleteBlog(@RequestParam Long id) {
		blogImpl.deleteBlog(id);
	}

}
