package com.example.bookshop.service;

import java.util.List;

import com.example.bookshop.entity.Category;

public interface CategoryService {
	List<Category> getCategories(int pageNo, int pageSize, String sortBy, String sortDir);

	Category getCategoryById(Long id);

	List<Category> getCategoryName(String name);

	Category addCategory(Category category);

	Category updateCategory(Category category);

	void deleteCategory(Long id);
}
