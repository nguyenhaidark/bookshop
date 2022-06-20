package com.example.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshop.entity.Category;
import com.example.bookshop.myfunction.AppConstants;
import com.example.bookshop.service.impl.CategoryImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryImpl categoryImpl;

	@GetMapping("/get")
	public List<Category> getAll(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return categoryImpl.getCategories(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/findById")
	public Category getById(@RequestParam Long id) {
		return categoryImpl.getCategoryById(id);
	}

	@GetMapping("/findByName")
	public List<Category> getByName(@RequestParam String name) {
		return categoryImpl.getCategoryName(name);
	}

	@PostMapping("/add")
	public Category addCategory(@RequestBody Category category) {
		return categoryImpl.addCategory(category);
	}

	@PutMapping("/update")
	public Category updateCategory(@RequestBody Category category) {
		return categoryImpl.updateCategory(category);
	}

	@DeleteMapping("/delete")
	public void Category(@RequestParam Long id) {
		categoryImpl.deleteCategory(id);
	}
}
